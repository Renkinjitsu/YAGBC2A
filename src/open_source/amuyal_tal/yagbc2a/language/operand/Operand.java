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

package open_source.amuyal_tal.yagbc2a.language.operand;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public abstract class Operand
{
	private final String _name;

	public Operand(final String name)
	{
		_name = name;
	}

	public abstract int getCodeSize();

	final public String getName()
	{
		return _name;
	}

	@Override
	public boolean equals(final Object obj)
	{
		final Operand other = (Operand)obj;

		return _name.equals(other._name);
	}

	public abstract boolean matches(final String string);

	public abstract BytesArray assemble(final String string);

//TODO: Implement (disassemble)
/*
	public abstract String disassemble(final byte[] machineCode);
*/
}