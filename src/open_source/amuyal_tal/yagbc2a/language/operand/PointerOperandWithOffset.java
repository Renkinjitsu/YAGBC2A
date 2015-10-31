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

import open_source.amuyal_tal.yagbc2a.utils.Utils;
import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.adt.MutableBytesArray;

public class PointerOperandWithOffset extends Operand implements PointerType
{
	private final Operand _pointingParameter;

	public PointerOperandWithOffset(final Operand pointingParameter)
	{
		super(pointingParameter.getName() + "+" + "r8");

		_pointingParameter = pointingParameter;
	}

	@Override
	public Operand getPointingParameter()
	{
		return _pointingParameter;
	}

	@Override
	public boolean matches(final String string)
	{
		final String[] parts = string.split("\\+");

		boolean result;

		if(parts.length != 2)
		{
			result = false;
		}
		else if(parts[0].equalsIgnoreCase(_pointingParameter.getName()) == false)
		{
			result = false;
		}
		else
		{
			result = Utils.isSignedByte(parts[1]);
		}

		return result;
	}

	@Override
	public int getCodeSize()
	{
		return _pointingParameter.getCodeSize() + 1;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		final BytesArray code = new MutableBytesArray();
		final String[] parts = string.split("\\+");

		final BytesArray pointingParameterCode = _pointingParameter.assemble(parts[0]);
		if(pointingParameterCode != null)
		{
			code.append(pointingParameterCode);
		}

		try
		{
			final int value = Integer.parseInt(parts[1]);
			code.append((byte)value);
		}
		catch(final NumberFormatException ex)
		{
			Utils.abort(ex);
		}

		return code;
	}
}
