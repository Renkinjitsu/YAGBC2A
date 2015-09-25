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

package open_source.amuyal_tal.yagbc2a.cartridege;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import open_source.amuyal_tal.yagbc2a.BootHeader;
import open_source.amuyal_tal.yagbc2a.HandledException;
import open_source.amuyal_tal.yagbc2a.ObjectFile;
import open_source.amuyal_tal.yagbc2a.SymbolTable;
import open_source.amuyal_tal.yagbc2a.utils.Utils;
import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public class Linker
{
	public class KnownSymbols
	{
		public static final String CODE_START_LABEL = "main";
		public static final String PROGRAM_NAME = "__program_name";
		public static final String MANUFACTURER_CODE = "__manufacturer_code";
	}

	private ObjectFile _objectFile;

	public Linker()
	{
		_objectFile = null;
	}

	public void linkObject(
			final ObjectFile objectFile
			)
	{
		_objectFile = objectFile;
	}

	public void emit(
			final String filePath
			) throws HandledException
	{
		final List<BytesArray> sections = new ArrayList<BytesArray>();

		sections.add(assembleBootHeader());
		sections.add(_objectFile.getDataSegmentSection(0, _objectFile.getDataSegmentSize()));
		sections.add(_objectFile.getCodeSegmentSection(0, _objectFile.getCodeSegmentSize()));

		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream(filePath);

			for(final BytesArray section : sections)
			{
				for(int i = 0; i < section.getSize(); i++)
				{
					out.write(section.getAt(i));
				}
			}

			out.close();
		}
		catch(final Throwable throwable)
		{
			Utils.displayError(throwable);

			throw new HandledException();
		}
		finally
		{
			if(out != null)
			{
				try
				{
					out.close();
				}
				catch(final Throwable throwable)
				{
					Utils.displayError(throwable);

					throw new HandledException();
				}
			}
		}
	}

	private BytesArray assembleBootHeader()
	{
		final int dataMemoryOffset = BootHeader.getSize();
		final int codeMemoryOffset = dataMemoryOffset + _objectFile.getDataSegmentSize();

		final BootHeader bootHeader = new BootHeader();

		//Get code-start-address
		if(_objectFile.getSymbolTable().isSymbolicLabelDefined(KnownSymbols.CODE_START_LABEL) == false)
		{
			final String error = String.format(
					"Code start label `%s` not defined",
					KnownSymbols.CODE_START_LABEL
					);
			Utils.abort(error);
		}
		final int mainAddress = codeMemoryOffset + _objectFile.getSymbolTable().getSymbolicLabelAddress(KnownSymbols.CODE_START_LABEL);

		//Get program name
		if(_objectFile.getSymbolTable().isSymbolicVariableDefined(KnownSymbols.PROGRAM_NAME) == false)
		{
			final String error = String.format(
					"Variable `%s` not defined",
					KnownSymbols.PROGRAM_NAME
					);
			Utils.abort(error);
		}

		final SymbolTable.VariableSymbol programNameSymbol = _objectFile.getSymbolTable().getSymbolicVariable(KnownSymbols.PROGRAM_NAME);
		final String programName = _objectFile.getDataSegmentSection(
				programNameSymbol.getAddress(),
				programNameSymbol.getSize()
				).toString();

		String manufacturerCode = "";
		if(_objectFile.getSymbolTable().isSymbolicVariableDefined(KnownSymbols.MANUFACTURER_CODE))
		{
			final SymbolTable.VariableSymbol manufacturerCodeSymbol = _objectFile.getSymbolTable().getSymbolicVariable(KnownSymbols.MANUFACTURER_CODE);
			manufacturerCode = _objectFile.getDataSegmentSection(
					manufacturerCodeSymbol.getAddress(),
					manufacturerCodeSymbol.getSize()
					).toString();
		}
		else if(_objectFile.getSymbolTable().isSymbolDefined(KnownSymbols.MANUFACTURER_CODE))
		{
			final String error = String.format(
					"Symbol `%s` should be defined as variable",
					KnownSymbols.PROGRAM_NAME
					);
			Utils.abort(error);
		}

		return bootHeader.assemble(
				mainAddress,
				programName,
				manufacturerCode
				);
	}
}
