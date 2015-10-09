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

package open_source.amuyal_tal.yagbc2a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import open_source.amuyal_tal.yagbc2a.data.InstructionImmediateNumberTemplate;
import open_source.amuyal_tal.yagbc2a.data.InstructionParameter;
import open_source.amuyal_tal.yagbc2a.instruction.InstructionTemplate;
import open_source.amuyal_tal.yagbc2a.object.FunctionSymbol;
import open_source.amuyal_tal.yagbc2a.object.LabelSymbol;
import open_source.amuyal_tal.yagbc2a.object.NumberVariableSymbol;
import open_source.amuyal_tal.yagbc2a.object.ObjectFile;
import open_source.amuyal_tal.yagbc2a.object.StringVariableSymbol;
import open_source.amuyal_tal.yagbc2a.object.Symbol;
import open_source.amuyal_tal.yagbc2a.object.SymbolTable;
import open_source.amuyal_tal.yagbc2a.object.UnresolvedSymbol;
import open_source.amuyal_tal.yagbc2a.object.VariableSymbol;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class Assembler
{
	public static ObjectFile assemble(
			final SourceFile sourceFile
			) throws HandledException
	{
		final Assembler assembler = new Assembler();
		final ObjectFile objectFile = new ObjectFile();

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
		assembler.removeEmptyLines(
				sourceFile
				);

		/*
		 * Second pass
		 *
		 * Dependencies:
		 *  None
		 */
		assembler.resolveLabels(
				sourceFile,
				objectFile
				);

		/*
		 * Third pass
		 *
		 * Dependencies:
		 *  None
		 */
		assembler.resolveVariableDefinitions(
				sourceFile,
				objectFile
				);

		/*
		 * Fourth pass
		 *
		 * Dependencies:
		 * - `resolveVariableDefinitions` - resolves symbols marked by this pass
		 */
		assembler.translateVariableSymbols(
				sourceFile,
				objectFile
				);

		/*
		 * Fifth pass
		 *
		 * Dependencies:
		 * - `removeEmptyLines` - no skipping of empty lines is done
		 * - `resolveLabels` - no labels skipping implemented
		 * - `resolveVariableDefinitions` - no variables skipping implemented
		 * - `translateVariableSymbols` - actual values required
		 */
		assembler.translateInstructions(
				sourceFile,
				objectFile
				);

		/*
		 * Sixth pass
		 *
		 * Dependencies:
		 * - `translateInstructions` - resolves symbols marked by this pass
		 */
		assembler.translateUnresolvedSymbols(
				sourceFile,
				objectFile
				);

		assembler.printErrors();

		return objectFile;
	}

	private class FunctionParsing
	{
		private final String _name;
		private final int _startAddress;
		private final SourceLine _declerationSourceLine;

		public FunctionParsing(
				final String name,
				final int startAddress,
				final SourceLine declerationSourceLine
				)
		{
			_name = name;
			_startAddress = startAddress;
			_declerationSourceLine = declerationSourceLine;
		}

		public String getName()
		{
			return _name;
		}

		public int getStartAddress()
		{
			return _startAddress;
		}

		public SourceLine getDeclerationSourceLine()
		{
			return _declerationSourceLine;
		}
	}

	private final List<String> _errors;
	private final List<UnresolvedSymbol> _unresolvedSymbols;

	private final List<FunctionParsing> _functionParsingData;

	private Assembler()
	{
		_errors = new LinkedList<String>();
		_unresolvedSymbols = new LinkedList<UnresolvedSymbol>();

		_functionParsingData = new LinkedList<FunctionParsing>();
	}

	private void removeEmptyLines(
			final SourceFile sourceFile
			)
	{
		final Iterator<SourceLine> iterator = sourceFile.iterator();

		while(iterator.hasNext())
		{
			if(iterator.next().isEmpty())
			{
				iterator.remove();
			}
		}
	}

	private void resolveLabels(
			final SourceFile sourceFile,
			final ObjectFile objectFile
			)
	{
		final Iterator<SourceLine> iterator = sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			while(sourceLine.getText().contains(":"))
			{
				final boolean has_error = parseLabel(sourceLine, objectFile);

				if(has_error || sourceLine.isEmpty())
				{
					iterator.remove();
				}
			}
		}
	}

	private void resolveVariableDefinitions(
			final SourceFile sourceFile,
			final ObjectFile objectFile
			)
	{
		final Iterator<SourceLine> iterator = sourceFile.iterator();

		while(iterator.hasNext())
		{
			final SourceLine sourceLine = iterator.next();

			if(sourceLine.getText().startsWith("define "))
			{
				parseVariableDefinition(sourceLine, objectFile);
				iterator.remove();
			}
		}
	}

	private void translateVariableSymbols(
			final SourceFile sourceFile,
			final ObjectFile objectFile
			)
	{
		final SymbolTable symbolTable = objectFile.getSymbolTable();

		final Iterator<SourceLine> iterator = sourceFile.iterator();

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

	private void translateInstructions(
			final SourceFile sourceFile,
			final ObjectFile objectFile
			)
	{
		{
			final Iterator<SourceLine> iterator = sourceFile.iterator();

			while(iterator.hasNext())
			{
				final SourceLine sourceLine = iterator.next();

				if(sourceLine.getText().startsWith("func"))
				{
					parseFunctionBegin(sourceLine, objectFile);
				}
				else if(sourceLine.getText().equalsIgnoreCase("end"))
				{
					parseFunctionEnd(sourceLine, objectFile);
				}
				else
				{
					parseInstruction(sourceLine, objectFile);
				}

				iterator.remove();
			}
		}

		if(_functionParsingData.isEmpty() == false)
		{
			final Iterator<FunctionParsing> iterator = _functionParsingData.iterator();

			while(iterator.hasNext())
			{
				final FunctionParsing functionData = iterator.next();

				final String error = String.format(
						"Marker \"end\" for function `%s` is not present",
						functionData.getName()
						);

				handleError(
						error,
						functionData.getDeclerationSourceLine()
						);
			}
		}
	}

	private void translateUnresolvedSymbols(
			final SourceFile sourceFile,
			final ObjectFile objectFile
			)
	{
		final Iterator<UnresolvedSymbol> iterator = _unresolvedSymbols.iterator();

		final SymbolTable symbolTable = objectFile.getSymbolTable();

		while(iterator.hasNext())
		{
			final UnresolvedSymbol unresolvedSymbol = iterator.next();

			if(symbolTable.isSymbolDefined(unresolvedSymbol.getSymbolName()) == false)
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
				final int address = Utils.getSymbolAbsoluteLocation(
						unresolvedSymbol.getSymbolName(),
						objectFile
						);
				if(Utils.neededSize(address) > unresolvedSymbol.getSize())
				{
					handleError(
							String.format(
									"Address size of symbol `%s` is too big",
									unresolvedSymbol.getSymbolName()
									),
							unresolvedSymbol.getSourceLine()
							);
				}
				else
				{
					final byte[] bigEndianAddress = Utils.toByteArray(address);
					final byte[] littleEndianAddress = Utils.getOtherEndianess(bigEndianAddress);
					objectFile.setCodeSegmentSection(
							unresolvedSymbol.getStartIndex(),
							littleEndianAddress
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

	private boolean parseLabel(
			final SourceLine sourceLine,
			final ObjectFile objectFile
			)
	{
		String error = null;

		final String lineText = sourceLine.getText();

		if(lineText.startsWith(":"))
		{
			error = "Label name missing";
		}
		else
		{
			final String[] parts = lineText.split(":");

			objectFile.getSymbolTable().insert(
					parts[0],
					new LabelSymbol(objectFile.getCodeSegmentSize())
					);

			if(parts.length > 1)
			{
				sourceLine.resetText(lineText.substring(parts[0].length() + 1));
			}
			else
			{
				sourceLine.resetText("");
			}
		}

		return handleError(error, sourceLine);
	}

	private void parseFunctionBegin(
			final SourceLine sourceLine,
			final ObjectFile objectFile
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
		else if(objectFile.getSymbolTable().isSymbolDefined(parts[1]))
		{
			error = String.format(
					"Duplicate symbol `%s`",
					parts[1]
					);
		}
		else if(InstructionParameterDataBase.searchByName(parts[1]) != null)
		{
			error = String.format(
					"Keyword `%s` is reserved as an instruction operand",
					parts[1]
					);
		}
		else
		{
			_functionParsingData.add(
					new FunctionParsing(
							parts[1],
							objectFile.getCodeSegmentSize(),
							sourceLine
							)
					);
		}

		handleError(error, sourceLine);
	}

	private void parseFunctionEnd(
			final SourceLine sourceLine,
			final ObjectFile objectFile
			)
	{
		String error = null;

		if(_functionParsingData.isEmpty())
		{
			error = "Function end with no beginning";
		}
		else
		{
			//Pop last item
			final int lastIndex = _functionParsingData.size() - 1;
			final FunctionParsing data = _functionParsingData.get(lastIndex);
			_functionParsingData.remove(lastIndex);

			final String functionName = data.getName();
			final int functionStartAddress = data.getStartAddress();
			final int functionSize = objectFile.getCodeSegmentSize() - functionStartAddress;

			objectFile.getSymbolTable().insert(
					functionName,
					new FunctionSymbol(
							functionStartAddress,
							functionSize
							)
					);
		}

		handleError(error, sourceLine);
	}

	private void parseVariableDefinition(
			final SourceLine sourceLine,
			final ObjectFile objectFile
			)
	{
		String error = null;

		final String parts[] = sourceLine.getText().split(" ");
		if(parts.length < 4)
		{
			error = "Too little arguments for `define`, should be `define [type] [name] [value]`";
		}
		else
		{
			final String name = parts[2];
			if(objectFile.getSymbolTable().isSymbolDefined(name))
			{
				error = String.format("Symbol `%s` previously defined", name);
			}
			else if(InstructionParameterDataBase.searchByName(name) != null)
			{
				error = String.format(
						"Keyword `%s` is reserved as an instruction operand",
						name
						);
			}
			else
			{
				switch(parts[1])
				{
					case "string":
					{
						String value = sourceLine.getText().substring(
								parts[0].length() + 1 + parts[1].length() + 1 + parts[2].length() + 1
								);

						if(value.startsWith("\"") == false)
						{
							error = "A string litheral must be preceded by quotation mark (\")";
						}
						else if(value.endsWith("\"") == false)
						{
							error = "A string litheral must be succeeded by quotation mark (\")";
						}
						else
						{
							value = value.substring(1, value.length() - 1); //Slice the quotation marks
							if(value.contains("\"")) //TODO: Replace with a Regex that looks for a quotation mark that is not escaped
							{
								error = "A string litheral may not include an unescaped quotation mark";
							}
							else
							{
								objectFile.getSymbolTable().insert(
										name,
										new StringVariableSymbol(
												objectFile.getDataSegmentSize(),
												value.length() + 1,
												value
												)
										);

								for(int i = 0; i < value.length(); i++)
								{
									final byte byteChar = (byte)value.charAt(i);
									objectFile.appendDataSegment(byteChar);
								}
								objectFile.appendDataSegment((byte)'\0'); //Add null-termination
							}
						}
					}
					break;

					case "byte":
					{
						error = parseNumberVariableDefinition(
								parts,
								1,
								objectFile
								);
					}
					break;

					case "word":
					{
						error = parseNumberVariableDefinition(
								parts,
								2,
								objectFile
								);
					}
					break;

					default:
					{
						error = String.format("Unknown type `%s`", parts[1]);
					}
					break;
				}
			}
		}

		handleError(
				error,
				sourceLine
				);
	}

	private String parseNumberVariableDefinition(
			final String parts[],
			final int bytesCount,
			final ObjectFile objectFile
			)
	{
		String error = null;

		//parts[] = {"define", "byte" / "word", "<variable name>", "<value>", ...};
		final int nameIndex = 2;
		final int valueIndex = 3;

		try
		{
			final int value = Utils.parseValue(parts[valueIndex]);

			if(Utils.neededSize(value) > bytesCount)
			{
				error = "Assigned value exceeds variable capacity";
			}
			else if(parts.length > 4)
			{
				error = "Unrecognized symbols after variable's value";
			}
			else
			{
				objectFile.getSymbolTable().insert(
						parts[nameIndex],
						new NumberVariableSymbol(
								objectFile.getDataSegmentSize(),
								bytesCount,
								value
								)
						);

				for(int i = 0; i < bytesCount; i++)
				{
					final int currentValue = (value >> (i * 8)) & 0xFF;
					objectFile.appendDataSegment((byte)currentValue);
				}
			}
		}
		catch(final NumberFormatException ex)
		{
			error = "Variable value is not a valid number";
		}

		return error;
	}

	private void parseInstruction(
			final SourceLine sourceLine,
			final ObjectFile objectFile
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
								objectFile,
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
			objectFile.appendCode(instruction.assemble(tokens));
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
			final ObjectFile objectFile,
			final SourceLine sourceLine
			)
	{
		final String argument = tokens.getArgument(argumentIndex);
		tokens.replaceArgument(argumentIndex, "0");

		InstructionTemplate instruction = InstructionDataBase.match(tokens);
		if(instruction != null)
		{
			final InstructionParameter parameter = instruction.getParameter(argumentIndex);
			if(parameter instanceof InstructionImmediateNumberTemplate)
			{
				final InstructionImmediateNumberTemplate immediateOperand = (InstructionImmediateNumberTemplate)parameter;
				if(immediateOperand.isAddress() == false)
				{
					instruction = null;
				}
				else
				{
					int location = objectFile.getCodeSegmentSize() + instruction.getSize();
					for(int i = argumentIndex; i < instruction.getParametersCount(); i++)
					{
						location -= instruction.getParameter(i).getCodeSize();
					}

					final UnresolvedSymbol unresolvedSymbol =
							new UnresolvedSymbol(
									argument,
									location,
									immediateOperand.getCodeSize(),
									sourceLine
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
}
