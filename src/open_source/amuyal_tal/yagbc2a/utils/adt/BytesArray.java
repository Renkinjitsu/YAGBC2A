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

package open_source.amuyal_tal.yagbc2a.utils.adt;


public abstract class BytesArray
{
	public abstract byte getAt(
			final int index
			);

	public abstract void setAt(
			final int index,
			final byte value
			);

	public abstract int getSize(
			);

	public abstract void append(
			final byte value
			);

	public abstract void append(
			final byte[] bytes
			);

	public abstract void append(
			final BytesArray other
			);

	public boolean compare(
			final BytesArray other
			)
	{
		if(getSize() != other.getSize())
		{
			return false;
		}

		for(int i = 0; i < getSize(); i++)
		{
			if(getAt(i) != other.getAt(i))
			{
				return false;
			}
		}

		return true;
	}

	public void override(
			final int startIndex,
			final byte[] bytes
			)
	{
		for(int i = 0; i < bytes.length; i++)
		{
			setAt(startIndex + i, bytes[i]);
		}
	}

	@Override
	public String toString()
	{
		String string = "";

		for(int i = 0; i < getSize(); i++)
		{
			final char ch = (char)getAt(i);

			if(ch == '\0')
			{
				break;
			}
			else
			{
				string += ch;
			}
		}

		return string;
	}
}
