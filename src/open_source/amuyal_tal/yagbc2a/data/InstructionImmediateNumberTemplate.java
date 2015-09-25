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

import open_source.amuyal_tal.yagbc2a.utils.Utils;
import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.adt.MutableBytesArray;

public final class InstructionImmediateNumberTemplate extends InstructionParameter
{
	private final boolean _isSigned;
	private final boolean _isImmediate;
	private final boolean _isEightBit;
	private final boolean _isAddress;

	public InstructionImmediateNumberTemplate(
			final String name,
			final boolean isSigned,
			final boolean isImmediate,
			final boolean isEightBit
			)
	{
		super(name);

		_isSigned = isSigned;
		_isImmediate = isImmediate;
		_isEightBit = isEightBit;
		_isAddress = (name.charAt(0) == 'a');
	}

	public boolean isSigned()
	{
		return _isSigned;
	}

	public boolean isImmediate()
	{
		return _isImmediate;
	}

	public boolean isEightBit()
	{
		return _isEightBit;
	}

	public boolean isAddress()
	{
		return _isAddress;
	}

	private boolean isInValidRange(final int value)
	{
		boolean result;

		if(isEightBit())
		{
			if(isSigned())
			{
				result = (-128 <= value) && (value <= 127);
			}
			else
			{
				result = (0 <= value) && (value <= 255);
			}
		}
		else
		{
			if(isSigned())
			{
				result = (-32768 <= value) && (value <= 32767);
			}
			else
			{
				result = (0 <= value) && (value <= 65535);
			}
		}

		return result;
	}

	@Override
	public boolean matches(final String string)
	{
		boolean result;

		try
		{
			final int value = Utils.parseValue(string);
			result = isInValidRange(value);
		}
		catch(final NumberFormatException ex)
		{
			result = false;
		}

		return result;
	}

	@Override
	public int getCodeSize()
	{
		return isEightBit() ? 1 : 2;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		final BytesArray code = new MutableBytesArray();

		final int value = Utils.parseValue(string);

		//TODO: Verify (and probably fix) for negative numbers
		if(isEightBit())
		{
			code.append((byte)value);
		}
		else
		{
			//Set in a little-endian layout
			code.append((byte)(value & 0xFF));
			code.append((byte)(value >> 8));
		}

		return code;
	}
}
