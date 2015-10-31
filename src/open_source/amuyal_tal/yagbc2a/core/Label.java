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

import open_source.amuyal_tal.yagbc2a.core.object.LabelSymbol;
import open_source.amuyal_tal.yagbc2a.core.object.SymbolTable;
import open_source.amuyal_tal.yagbc2a.parsing.SourceLine;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

public class Label implements AddressAssignable
{
	private final String _name;
	private final SourceLine _decelerationSourceLine;
	private final SymbolTable _owningSymbolTable;

	private boolean _hasAddressAssigned;

	public Label(
			final String name,
			final SourceLine decelerationSourceLine,
			final SymbolTable owningSymbolTable
			)
	{
		_name = name;
		_decelerationSourceLine = decelerationSourceLine;
		_owningSymbolTable = owningSymbolTable;

		_hasAddressAssigned = false;
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
				new LabelSymbol(
						address
						)
				);
	}

	@Override
	public int getDecelerationLineNumber()
	{
		return _decelerationSourceLine.getLineNumber();
	}
}
