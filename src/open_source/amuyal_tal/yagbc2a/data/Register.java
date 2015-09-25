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

package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public class Register extends InstructionParameter
{
	public enum RegisterBitCount
	{
		EIGHT(8),
		SIXTEEN(16);

		private final int _bits;

		private RegisterBitCount(final int bits)
		{
			_bits = bits;
		}

		public int getValue()
		{
			return _bits;
		}
	}

	private final RegisterBitCount _registerBitCount;
	private final boolean _isWritable;

	public Register(
			final String name,
			final RegisterBitCount registerBitCount,
			final boolean isWritable
			)
	{
		super(name);

		_registerBitCount = registerBitCount;
		_isWritable = isWritable;
	}

	public RegisterBitCount getRegisterBitCount()
	{
		return _registerBitCount;
	}

	public boolean isWritable()
	{
		return _isWritable;
	}

	@Override
	public boolean matches(final String string)
	{
		return (getName().equalsIgnoreCase(string));
	}

	@Override
	public int getCodeSize()
	{
		return 0;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		return null;
	}
}
