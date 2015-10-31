/*
    Yet Another Gameboy Classic/Color Assembler (YAGBC2A) can compile Gameboy-compatible images.
    Copyright (C) 2015  Tal Amuyal

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

	Contact information (email): TalAmuyal@gmail.com
*/

package open_source.amuyal_tal.yagbc2a.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import open_source.amuyal_tal.yagbc2a.HandledException;
import open_source.amuyal_tal.yagbc2a.InstructionDataBase;
import open_source.amuyal_tal.yagbc2a.OperandDataBase;
import open_source.amuyal_tal.yagbc2a.core.object.NumberVariableSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.ObjectFile;
import open_source.amuyal_tal.yagbc2a.core.object.StringVariableSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.Symbol;
import open_source.amuyal_tal.yagbc2a.core.object.SymbolTable;
import open_source.amuyal_tal.yagbc2a.core.object.UnresolvedSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.VariableSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.cartridge.BootHeader;
import open_source.amuyal_tal.yagbc2a.language.instruction.InstructionTemplate;
import open_source.amuyal_tal.yagbc2a.language.operand.ImmediateNumberOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.Operand;
import open_source.amuyal_tal.yagbc2a.parsing.CommandTokens;
import open_source.amuyal_tal.yagbc2a.parsing.SourceFile;
import open_source.amuyal_tal.yagbc2a.parsing.SourceLine;
import open_source.amuyal_tal.yagbc2a.parsing.SyntaxException;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class Assembler
{
	public static ObjectFile assemble(
			final SourceFile sourceFile
			) throws HandledException
	{
		final Assembler assembler = new Assembler(sourceFile);

		/*
		 * The following are calls for different passes. Each pass may modify the code.
		 * Some passes depends on other. Dependencies are documented, followed by their
		 * respective reasons.
		 */

		/*
		 * First pass
		 *
		 * Dependencies:
		 *  None
		 */
		assembler.removeEmptyLines();

		/*
		 * Second pass
		 *
		 * Dependencies:
		 *  None
		 */
		assembler.detectFunctions();

		/*
		 * Third pass
		 *
		 * Dependencies:
		 *  - `detectFunctions` - labels may be function local. such labels are registered in
		 *     the function's symbol table.
		 */
		assembler.detectLabels();

		/*
		 * Fourth pass
		 *
		 * Dependencies:
		 *  - `detectFunctions` - variables may be function local. such variables are registered in
		 *     the function's symbol table
		 */
		assembler.resolveVariableDefinitions();

		/*
		 * Fifth pass
		 *
		 * Dependencies:
		 * - `resolveVariableDefinitions` - resolves symbols marked by this pass
		 */
		assembler.translateVariableSymbols();

		/*
		 * Sixth pass
		 *
		 * Dependencies:
		 * - `removeEmptyLines` - no skipping of empty lines is done
		 * - `detectFunctions` - no function skipping implemented
		 * - `detectFunctions` - function data is assigned
		 * - `detectLabels` - no labels skipping implemented
		 * - `detectLabels` - label data is assigned
		 * - `resolveVariableDefinitions` - no variables skipping implemented
		 * - `translateVariableSymbols` - actual values required
		 */
		assembler.translateInstructions();

		/*
		 * Seventh pass
		 *
		 * Dependencies:
		 * - `translateInstructions` - resolves symbols marked by this pass
		 */
		assembler.translateUnresolvedSymbols();

		assembler.printErrors();

		return assembler.getObjectFile();
	}

	private final ObjectFile _objectFile;
	private final SourceFile _sourceFile;

	private final List<String> _errors;
	private final List<UnresolvedSymbol> _unresolvedSymbols;

	private final List<Function> _functions;
	private final List<Label> _labels;

	private Assembler(
			final SourceFile sourceFile
			)
	{
		_objectFile = new ObjectFile();
		_sourceFile = sourceFile;

		_errors = new LinkedList<String>();
		_unresolvedSymbols = new LinkedList<UnresolvedSymbol>();

		_functions = new LinkedList<Function>(); //`LinkedList` is the chosen implementation, as only `add(E)` and iterator operations are done
		_labels = new LinkedList<Label>(); //`LinkedList` is the chosen implementation, as only `add(E)` and iterator operations are done
	}

	private void removeEmptyLines()
	{
		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			if(iterator.next().isEmpty())
			{
				iterator.remove();
			}
		}
	}

	private void detectFunctions()
	{
		final Stack<Function> detectedFunctions = new Stack<Function>();

		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			if(sourceLine.getText().startsWith("func"))
			{
				parseFunctionBegin(
						sourceLine,
						detectedFunctions
						);
				iterator.remove();
			}
			else if(sourceLine.getText().equalsIgnoreCase("end"))
			{
				parseFunctionEnd(
						sourceLine,
						detectedFunctions
						);
				iterator.remove();
			}
		}

		while(detectedFunctions.isEmpty() == false)
		{
			final Function functionData = detectedFunctions.pop();

			final String error = String.format(
					"Function `%s` isn't termintated, missing \"end\" marker",
					functionData.getName()
					);

			handleError(
					error,
					functionData.getDecelerationSourceLine()
					);
		}
	}

	private void detectLabels()
	{
		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			while(sourceLine.getText().contains(":"))
			{
				parseLabel(
						sourceLine
						);

				if(sourceLine.isEmpty())
				{
					iterator.remove();
				}
			}
		}
	}

	private void resolveVariableDefinitions()
	{
		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			if(sourceLine.getText().startsWith("define "))
			{
				parseVariableDefinition(
						sourceLine
						);
				iterator.remove();
			}
		}
	}

	private void translateVariableSymbols()
	{
		final SymbolTable symbolTable = _objectFile.getSymbolTable();

		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			CommandTokens tokens;
			try
			{
				tokens = new CommandTokens(sourceLine.getText());
			}
			catch (final SyntaxException e)
			{
				continue; //Skip lines that can't be parsed
			}

			for(int i = 0; i < tokens.getArgumentsCount(); i++)
			{
				final boolean isValueUsage = tokens.getArgument(i).startsWith("*");
				final boolean isAddressUsage = tokens.getArgument(i).startsWith("&");
				final boolean isVariableUsed = isValueUsage || isAddressUsage;

				if(isVariableUsed)
				{
					final String variableName = tokens.getArgument(i).substring(1);

					if(symbolTable.isSymbolDefined(variableName) == false)
					{
						handleError(
								String.format(
										"Unrecognized variable `%s`",
										variableName
										),
								sourceLine
								);
						continue;
					}

					final Symbol symbol = symbolTable.getSymbol(variableName);
					if((symbol instanceof VariableSymbol) == false)
					{
						handleError(
								String.format(
										"Symbol `%s` is not a variable",
										variableName
										),
								sourceLine
								);
						continue;
					}

					final VariableSymbol variableSymbol = (VariableSymbol)symbol;

					if(isValueUsage)
					{
						tokens.replaceArgument(i, variableSymbol.toString());
					}
					else //if(isAddressUsage)
					{
						final int variableRelativeAddress = variableSymbol.getAddress();

						tokens.replaceArgument(i, "(" + Integer.toString(BootHeader.getSize() + variableRelativeAddress) + ")");
					}

					sourceLine.resetText(tokens.toString());
				}
			}
		}
	}

	private void translateInstructions()
	{
		final AddressAssignables addresslessSymbols = new AddressAssignables();
		addresslessSymbols.addAll(_functions);
		addresslessSymbols.addAll(_labels);
		addresslessSymbols.sort();

		final Iterator<SourceLine> iterator = _sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			addresslessSymbols.assignAddress(
					sourceLine.getLineNumber(),
					_objectFile.getCodeSegmentSize()
					);

			parseInstruction(sourceLine);

			iterator.remove();
		}

		addresslessSymbols.assignRemaining(
				_objectFile.getCodeSegmentSize()
				);
	}

	private void translateUnresolvedSymbols()
	{
		final Iterator<UnresolvedSymbol> iterator = _unresolvedSymbols.iterator();

		final SymbolTable globalSymbolTable = _objectFile.getSymbolTable();

		while(iterator.hasNext())
		{
			final UnresolvedSymbol unresolvedSymbol = iterator.next();

			//The owning function is the owner of the symbol usage
			final Function owningFunction = getOwningFunction(
					unresolvedSymbol.getSourceLine().getLineNumber()
					);

			//Data to be searched for
			SymbolTable symbolTable = null;
			boolean isFunctionLocal = false;

			if(owningFunction != null)
			{
				final SymbolTable functionSymbolTable = owningFunction.getLocalSymbolTable();

				if(functionSymbolTable.isSymbolDefined(
						unresolvedSymbol.getSymbolName()
						))
				{
					symbolTable = functionSymbolTable;
					isFunctionLocal = true;
				}
			}

			if(symbolTable == null)
			{
				if(globalSymbolTable.isSymbolDefined(unresolvedSymbol.getSymbolName()))
				{
					symbolTable = globalSymbolTable;
				}
			}

			if(symbolTable == null)
			{
				handleError(
						String.format(
								"Unrecognized symbol `%s`",
								unresolvedSymbol.getSymbolName()
								),
						unresolvedSymbol.getSourceLine()
						);
			}
			else
			{
				final Symbol symbol = symbolTable.getSymbol(
						unresolvedSymbol.getSymbolName()
						);

				if(isFunctionLocal && symbol instanceof VariableSymbol)
				{
					handleError(
							"Function-local variables are not supported",
							unresolvedSymbol.getSourceLine()
							);
				}
				else
				{
					final int segmentRelativeAddress = symbol.getAddress();

					final int bootHeaderToSegmentOffset =
							(symbol instanceof VariableSymbol) ? 0 : _objectFile.getDataSegmentSize(); //Data segment precedes code segment

					final int absoluteAddress = BootHeader.getSize() + bootHeaderToSegmentOffset + segmentRelativeAddress;

					Utils.assertCondition(0 <= absoluteAddress && absoluteAddress <= 0xFFFF);

					byte[] addressArray = null;

					//The non-`else` cases are non-standard usage of addresses by specific instructions
					final InstructionTemplate instruction = unresolvedSymbol.getInstruction();
					if(instruction.getCommand().equals("JR"))
					{
						Utils.assertCondition(unresolvedSymbol.getSize() == 1);

						final int lastOperandIndex = instruction.getParametersCount() - 1;
						Utils.assertCondition(1 == lastOperandIndex);
						Utils.assertCondition(unresolvedSymbol.getOperandIndex() == lastOperandIndex);

						//The address of the instruction's beginning
						final int usageAddress = unresolvedSymbol.getStartIndex() - 1; //'1' is the size of JR (without the address)

						//Wished amount of bytes to skip
						final int addressesOffset = absoluteAddress - usageAddress;

						//Actual amounts of bytes to skip
						final int jumpBytes = addressesOffset - 2;

						addressArray = new byte[1];
						addressArray[0] = (byte)jumpBytes;
						if(jumpBytes != (int)addressArray[0])
						{
							handleError(
									"Distance between jump command and destination address is too far for a relative jump",
									unresolvedSymbol.getSourceLine()
									);

							/*
							 * No abortion is places here, as it will add to the complexity of this function.
							 * This is not of any concern, as the compilation has already marked as failed.
							 */
						}
					}
					else if(instruction.getCommand().equals("LD") &&
							instruction.getParametersCount() == 2 &&
							instruction.getParameter(0) == OperandDataBase.searchByName("HL") &&
							instruction.getParameter(1) == OperandDataBase.searchByName("SP+r8"))
					{
						//TODO: Implement together with function-local variables

						handleError(
								"Function-local variables are not supported",
								unresolvedSymbol.getSourceLine()
								);
					}
					else if(instruction.getName().equals("LDH"))
					{
						addressArray = new byte[1];

						if(absoluteAddress < 0xFF00)
						{
							handleError(
									String.format(
											"Address size of symbol `%s` is too big",
											unresolvedSymbol.getSymbolName()
											),
											unresolvedSymbol.getSourceLine()
									);

							/*
							 * No abortion is places here, as it will add to the complexity of this function.
							 * This is not of any concern, as the compilation has already marked as failed.
							 */
						}
						else
						{
							addressArray[0] = (byte)(absoluteAddress - 0xFF00);
						}
					}
					else //Normal/regular/default case
					{
						Utils.assertCondition(unresolvedSymbol.getSize() == 2);

						final byte[] bigEndianAddress = Utils.toByteArray(absoluteAddress);
						addressArray = Utils.getOtherEndianess(bigEndianAddress);
					}

					_objectFile.setCodeSegmentSection(
							unresolvedSymbol.getStartIndex(),
							addressArray
							);
				}
			}

			iterator.remove();
		}
	}

	private boolean handleError(
			final String error,
			final SourceLine sourceLine
			)
	{
		if(error == null)
		{
			//No error to be recorded
		}
		else if(sourceLine == null)
		{
			_errors.add(error);
		}
		else
		{
			_errors.add(String.format("%s - at line %d",
					error,
					sourceLine.getLineNumber()
					));
		}

		return (error != null);
	}

	private void printErrors() throws HandledException
	{
		if(_errors.isEmpty() == false)
		{
			System.out.println("Errors:");
			for(final String error : _errors)
			{
				System.out.println(error);
			}

			throw new HandledException();
		}
	}

	private void parseLabel(
			final SourceLine sourceLine
			)
	{
		final SymbolTable symbolTable = getInnermostSymbolTable(
				sourceLine.getLineNumber()
				);

		final String lineText = sourceLine.getText();

		if(lineText.startsWith(":"))
		{
			handleError("Label name missing", sourceLine);
		}
		else
		{
			final String[] parts = lineText.split(":");

			_labels.add(
					new Label(
							parts[0],
							sourceLine,
							symbolTable
							)
					);

			//Remove the parsed code
			{
				final int parsedCodeLength = parts[0].length() + 1; //Length of label name + 1 for ':'
				sourceLine.resetText(lineText.substring(parsedCodeLength).trim()); //Trimming in case of space (e.g. "myLabel: myCode")
			}
		}
	}

	private void parseFunctionBegin(
			final SourceLine sourceLine,
			final Stack<Function> detectedFunctions
			)
	{
		String error = null;

		final String parts[] = sourceLine.getText().split(" ");
		if(parts.length == 1)
		{
			error = "missing function name";
		}
		else if(parts.length > 2)
		{
			error = String.format(
					"Detected function with name `%s`, further symbols not recognized",
					parts[1]
					);
		}
		else if(_objectFile.getSymbolTable().isSymbolDefined(parts[1]))
		{
			error = String.format(
					"Duplicate symbol `%s`",
					parts[1]
					);
		}
		else if(OperandDataBase.searchByName(parts[1]) != null)
		{
			error = String.format(
					"Keyword `%s` is reserved as an instruction operand",
					parts[1]
					);
		}
		else if(detectedFunctions.size() > 0)
		{
			error = "Nested functions not supported";
		}
		else
		{
			final Function function = new Function(
					parts[1],
					sourceLine,
					_objectFile.getSymbolTable()
					);

			detectedFunctions.push(
					function
					);
		}

		handleError(error, sourceLine);
	}

	private void parseFunctionEnd(
			final SourceLine sourceLine,
			final Stack<Function> detectedFunctions
			)
	{
		String error = null;

		if(detectedFunctions.isEmpty())
		{
			error = "Function end with no beginning";
		}
		else
		{
			final Function function = detectedFunctions.pop();

			function.setTermintaionSourceLine(
					sourceLine
					);

			_functions.add(
					function
					);
		}

		handleError(error, sourceLine);
	}

	private void parseVariableDefinition(
			final SourceLine sourceLine
			)
	{
		final SymbolTable symbolTable = getInnermostSymbolTable(
				sourceLine.getLineNumber()
				);

		final String parts[] = sourceLine.getText().split(" ");
		if(parts.length < 4)
		{
			handleError(
					"Too little arguments for `define`, should be `define [type] [name] [value]`",
					sourceLine
					);
		}
		else
		{
			final String name = parts[2];
			if(symbolTable.isSymbolDefined(name))
			{
				handleError(
						String.format("Symbol `%s` previously defined in current scope", name),
						sourceLine
						);
			}
			else if(OperandDataBase.searchByName(name) != null)
			{
				handleError(
						String.format(
								"Keyword `%s` is reserved as an instruction operand",
								name
								),
						sourceLine
						);
			}
			else
			{
				final Function owningFunction = getOwningFunction(
						sourceLine.getLineNumber()
						);

				switch(parts[1])
				{
					case "string":
					{
						parseStringVariableDefinition(
								parts,
								sourceLine,
								symbolTable,
								owningFunction
								);
					}
					break;

					case "byte":
					{
						parseNumberVariableDefinition(
								parts,
								1,
								sourceLine,
								symbolTable,
								owningFunction
								);
					}
					break;

					case "word":
					{
						parseNumberVariableDefinition(
								parts,
								2,
								sourceLine,
								symbolTable,
								owningFunction
								);
					}
					break;

					default:
					{
						handleError(
								String.format("Unknown type `%s`", parts[1]),
								sourceLine
								);
					}
					break;
				}
			}
		}
	}

	private void parseStringVariableDefinition(
			final String parts[],
			final SourceLine sourceLine,
			final SymbolTable symbolTable,
			final Function owningFunction
			)
	{
		String value = sourceLine.getText().substring(
				parts[0].length() + 1 + parts[1].length() + 1 + parts[2].length() + 1
				);

		if(value.startsWith("\"") == false)
		{
			handleError(
					"A string litheral must be preceded by quotation mark (\")",
					sourceLine
					);
		}
		else if(value.endsWith("\"") == false)
		{
			handleError(
					"A string litheral must be succeeded by quotation mark (\")",
					sourceLine
					);
		}
		else
		{
			value = value.substring(1, value.length() - 1); //Slice the quotation marks
			if(value.contains("\"")) //TODO: Replace with a Regex that looks for a quotation mark that is not escaped
			{
				handleError(
						"A string litheral may not include an unescaped quotation mark",
						sourceLine
						);
			}
			else
			{
				if(owningFunction == null) //Global variable
				{
					symbolTable.insert(
							parts[2],
							new StringVariableSymbol(
									_objectFile.getDataSegmentSize(),
									value.length() + 1,
									value
									)
							);

					for(int i = 0; i < value.length(); i++)
					{
						final byte byteChar = (byte)value.charAt(i);
						_objectFile.appendDataSegment(byteChar);
					}
					_objectFile.appendDataSegment((byte)'\0'); //Add null-termination
				}
				else //The symbol is owned by a function, so it resides in a stack frame
				{
					handleError(
							"Local variables are not supported",
							sourceLine
							);
				}
			}
		}
	}

	private void parseNumberVariableDefinition(
			final String parts[],
			final int bytesCount,
			final SourceLine sourceLine,
			final SymbolTable symbolTable,
			final Function owningFunction
			)
	{
		//parts[] = {"define", "byte" / "word", "<variable name>", "<value>", ...};
		final int nameIndex = 2;
		final int valueIndex = 3;

		try
		{
			final int value = Utils.parseValue(parts[valueIndex]);

			if(value < 0)
			{

				handleError(
						"Negative numbers are not supported",
						sourceLine
						);
			}
			else if(Utils.neededSize(value) > bytesCount)
			{

				handleError(
						"Assigned value exceeds variable capacity",
						sourceLine
						);
			}
			else if(parts.length > 4)
			{

				handleError(
						"Unrecognized symbols after variable's value",
						sourceLine
						);
			}
			else if(owningFunction == null) //Global variable
			{
				symbolTable.insert(
						parts[nameIndex],
						new NumberVariableSymbol(
								_objectFile.getDataSegmentSize(),
								bytesCount,
								value
								)
						);

				for(int i = 0; i < bytesCount; i++)
				{
					final int currentValue = (value >> (i * 8)) & 0xFF;
					_objectFile.appendDataSegment((byte)currentValue);
				}
			}
			else //The symbol is owned by a function, so it resides in a stack frame
			{
				handleError(
						"Local variables are not supported",
						sourceLine
						);
			}
		}
		catch(final NumberFormatException ex)
		{

			handleError(
					"Variable value is not a valid number",
					sourceLine
					);
		}
	}

	private void parseInstruction(
			final SourceLine sourceLine
			)
	{
		String error = null;
		CommandTokens tokens = null;
		InstructionTemplate instruction = null;

		try
		{
			tokens = new CommandTokens(sourceLine.getText());
		}
		catch(final SyntaxException e)
		{
			error = e.getLocalizedMessage();
		}

		if(error == null)
		{
			if(InstructionDataBase.isCommandRecognized(tokens.getCommand()) == false)
			{
				error = String.format("Unrecognized symbol `%s`",
						tokens.getCommand()
						);
			}
			else
			{
				instruction = InstructionDataBase.match(tokens);
				if(instruction == null)
				{
					final int i = InstructionDataBase.getFirstUnrecognizedParameterIndex(tokens);

					if(i < 0 || i >= tokens.getArgumentsCount())
					{
						error = "Unknown error has accured at instruction selection phase";
					}
					else
					{
						instruction = getInstructionPlaceHolder(
								tokens,
								i,
								sourceLine
								);
						if(instruction == null)
						{
							error = String.format("Parameter `%s` doesn't fit for instruction `%s` as argument %d",
									tokens.getArgument(i),
									tokens.getCommand(),
									i
									);
						}
					}
				}
			}
		}

		if(error == null)
		{
			_objectFile.appendCode(instruction.assemble(tokens));
		}
		else
		{
			handleError(
					error,
					sourceLine
					);
		}
	}

	private InstructionTemplate getInstructionPlaceHolder(
			final CommandTokens tokens,
			final int argumentIndex,
			final SourceLine sourceLine
			)
	{
		final String argument = tokens.getArgument(argumentIndex);
		tokens.replaceArgument(argumentIndex, "0");

		InstructionTemplate instruction = InstructionDataBase.match(tokens);
		if(instruction != null)
		{
			final Operand parameter = instruction.getParameter(argumentIndex);
			if(parameter instanceof ImmediateNumberOperand)
			{
				final ImmediateNumberOperand immediateOperand = (ImmediateNumberOperand)parameter;
				if(immediateOperand.isAddress() == false)
				{
					instruction = null;
				}
				else
				{
					int location = _objectFile.getCodeSegmentSize() + instruction.getSize();
					for(int i = argumentIndex; i < instruction.getParametersCount(); i++)
					{
						location -= instruction.getParameter(i).getCodeSize();
					}

					final UnresolvedSymbol unresolvedSymbol =
							new UnresolvedSymbol(
									argument,
									location,
									immediateOperand.getCodeSize(),
									sourceLine,
									instruction,
									argumentIndex
									);

					_unresolvedSymbols.add(unresolvedSymbol);
				}
			}
			else
			{
				Utils.abort("Unreasonable condition achived");
			}
		}

		return instruction;
	}

	private ObjectFile getObjectFile()
	{
		return _objectFile;
	}

	private SymbolTable getInnermostSymbolTable(
			final int sourceLineNumber
			)
	{
		final Function owningFunction = getOwningFunction(
				sourceLineNumber
				);

		return (owningFunction == null) ?
				_objectFile.getSymbolTable() :
					owningFunction.getLocalSymbolTable();
	}

	private Function getOwningFunction(
			final int sourceLineNumber
			)
	{
		for(final Function function : _functions)
		{
			if(function.isOwnerOf(sourceLineNumber))
			{
				return function;
			}
		}

		return null;
	}
}
