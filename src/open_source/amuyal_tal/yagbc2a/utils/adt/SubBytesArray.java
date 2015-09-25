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

public class SubBytesArray extends BytesArray
{
	private final BytesArray _pointed;
	private final int _startIndex;
	private final int _length;

	public SubBytesArray(
			final BytesArray bytesArray,
			final int startIndex,
			final int length
			)
	{
		_pointed = bytesArray;

		_startIndex = startIndex;
		_length = length;
	}

	@Override
	public byte getAt(
			final int index
			)
	{
		Utils.assertCondition(index >= 0);
		Utils.assertCondition(index < _length);

		return _pointed.getAt(_startIndex + index);
	}

	@Override
	public void setAt(
			final int index,
			final byte value
			)
	{
		Utils.assertCondition(index >= 0);
		Utils.assertCondition(index < _length);

		_pointed.setAt(_startIndex + index, value);
	}

	@Override
	public int getSize()
	{
		return _length;
	}

	@Override
	public void append(
			final byte value
			)
	{
		Utils.ilegalOperation();
	}

	@Override
	public void append(final byte[] bytes)
	{
		Utils.ilegalOperation();
	}

	@Override
	public void append(
			final BytesArray other
			)
	{
		Utils.ilegalOperation();
	}
}
