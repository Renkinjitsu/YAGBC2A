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

import java.util.Vector;

public class MutableBytesArray extends BytesArray
{
	private final Vector<MutableByte> _bytes;

	public MutableBytesArray()
	{
		_bytes = new Vector<MutableByte>();
	}

	public MutableBytesArray(
			final byte[] bytes
			)
	{
		_bytes = new Vector<MutableByte>();

		append(bytes);
	}

	@Override
	public byte getAt(
			final int index
			)
	{
		return _bytes.get(index).getValue();
	}

	@Override
	public void setAt(
			final int index,
			final byte value
			)
	{
		_bytes.get(index).setValue(value);
	}

	@Override
	public int getSize()
	{
		return _bytes.size();
	}

	@Override
	public void append(
			final byte value
			)
	{
		_bytes.add(new MutableByte(value));
	}

	@Override
	public void append(
			final byte[] bytes
			)
	{
		_bytes.ensureCapacity(_bytes.size() + bytes.length);

		for(int i = 0; i < bytes.length; i++)
		{
			append(bytes[i]);
		}
	}

	@Override
	public void append(
			final BytesArray other
			)
	{
		_bytes.ensureCapacity(_bytes.size() + other.getSize());

		for(int i = 0; i < other.getSize(); i++)
		{
			append(other.getAt(i));
		}
	}

}
