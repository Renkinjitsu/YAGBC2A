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

import open_source.amuyal_tal.yagbc2a.utils.Utils;

public class BytesArrayPointer extends BytesArray
{
	private final BytesArray _pointed;
	private final int _startIndex;

	public BytesArrayPointer(
			final BytesArray bytesArray,
			final int startIndex
			)
	{
		_pointed = bytesArray;

		_startIndex = startIndex;
	}

	@Override
	public byte getAt(
			final int index
			)
	{
		return _pointed.getAt(_startIndex + index);
	}

	@Override
	public void setAt(
			final int index,
			final byte value
			)
	{
		_pointed.setAt(_startIndex + index, value);
	}

	@Override
	public int getSize()
	{
		final int size = _pointed.getSize() - _startIndex;

		Utils.assertCondition(size >= 0);

		return size;
	}

	@Override
	public void append(
			final byte value
			)
	{
		_pointed.append(value);
	}

	@Override
	public void append(final byte[] bytes)
	{
		_pointed.append(bytes);
	}

	@Override
	public void append(
			final BytesArray other
			)
	{
		_pointed.append(other);
	}
}
