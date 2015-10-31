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

import open_source.amuyal_tal.yagbc2a.core.object.FunctionSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.SymbolTable;
import open_source.amuyal_tal.yagbc2a.parsing.SourceLine;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

final class Function implements AddressAssignable
{
	private final String _name;
	private final SourceLine _decelerationSourceLine;
	private final SymbolTable _localSymbolTable;
	private final SymbolTable _owningSymbolTable;

	private SourceLine _terminationSourceLine;
	private boolean _hasAddressAssigned;

	public Function(
			final String name,
			final SourceLine decelerationSourceLine,
			final SymbolTable owningSymboleTable
			)
	{
		_name = name;
		_decelerationSourceLine = decelerationSourceLine;

		_localSymbolTable = new SymbolTable();
		_owningSymbolTable = owningSymboleTable;
		_terminationSourceLine = null; //Unknown at the moment
		_hasAddressAssigned = false;
	}

	public String getName()
	{
		return _name;
	}

	public SymbolTable getLocalSymbolTable()
	{
		return _localSymbolTable;
	}

	@Override
	public void assignAddress(
			final int address
			)
	{
		Utils.assertCondition(_hasAddressAssigned == false);

		_hasAddressAssigned = true;

		_owningSymbolTable.insert(
				_name,
				new FunctionSymbol(
						address,
						0
						)
				);
	}

	public SourceLine getDecelerationSourceLine()
	{
		return _decelerationSourceLine;
	}

	@Override
	public int getDecelerationLineNumber()
	{
		return _decelerationSourceLine.getLineNumber();
	}

	public void setTermintaionSourceLine(
			final SourceLine terminationSourceLine
			)
	{
		Utils.assertCondition(_terminationSourceLine == null);

		_terminationSourceLine = terminationSourceLine;
	}

	public SourceLine getTermintaionSourceLine()
	{
		Utils.assertCondition(_terminationSourceLine != null);

		return _terminationSourceLine;
	}

	public boolean isOwnerOf(
			final int sourceLineNumber
			)
	{
		Utils.assertCondition(_terminationSourceLine != null);

		return (_decelerationSourceLine.getLineNumber() < sourceLineNumber) && (sourceLineNumber < _terminationSourceLine.getLineNumber());
	}
}
