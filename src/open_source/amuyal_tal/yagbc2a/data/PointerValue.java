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


public class PointerValue extends InstructionParameter implements PointerType
{
	private final InstructionParameter _pointingParameter;

	public PointerValue(final InstructionParameter pointingParameter)
	{
		super(String.format("(%s)", pointingParameter.getName()));

		_pointingParameter = pointingParameter;
	}

	@Override
	public InstructionParameter getPointingParameter()
	{
		return _pointingParameter;
	}

	@Override
	public boolean matches(final String string)
	{
		return (string.length() > 2) &&
				(string.charAt(0) == '(') &&
				(string.charAt(string.length() -1) == ')') &&
				_pointingParameter.matches(getPointingPart(string));
	}

	@Override
	public int getCodeSize()
	{
		return _pointingParameter.getCodeSize();
	}

	@Override
	public BytesArray assemble(final String string)
	{
		return _pointingParameter.assemble(getPointingPart(string));
	}

	private static String getPointingPart(final String string)
	{
		return string.substring(1, string.length() - 1);
	}
}
