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

import open_source.amuyal_tal.yagbc2a.parsing.SourceLine;

final class FunctionParsing
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
