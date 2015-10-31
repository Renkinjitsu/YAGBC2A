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

package open_source.amuyal_tal.yagbc2a.parsing;

public final class Syntax
{
	public static final String COMMENT_SYMBOL = ";";

	public static final int ADDRESS_CODE_START = 0x0100;
	public static final int ADDRESS_STACK_POINTER_DEFAULT = 0x0FFE;

	public final class Error
	{
		public static final String MISSING_PARAMETER_VALUE = "Missing parameter value";
		public static final String TOO_MANY_SYMBOLS = "Too many symbols";
		public static final String TOO_MANY_ARGUMENSTS = "Too many arguments";
		public static final String TOO_LITTLE_ARGUMENTS = "Too little arguments";
	}
}
