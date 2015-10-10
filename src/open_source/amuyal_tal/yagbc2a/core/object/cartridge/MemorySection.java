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

package open_source.amuyal_tal.yagbc2a.core.object.cartridge;

public class MemorySection
{
	private static final byte DEFAULT_VALUE = (byte)0x00;

	private final String _name;
	private final byte[] _data;

	public MemorySection(
			final String name,
			final int size,
			final byte repeatValue
			)
	{
		_name = name;
		_data = new byte[size];

		for(int i = 0; i < size; i++)
		{
			_data[i] = repeatValue;
		}
	}

	public MemorySection(
			final String name,
			final int size
			)
	{
		this(
				name,
				size,
				DEFAULT_VALUE
				);
	}

	public void setByte(
			final int index,
			final byte value
			)
	{
		_data[index] = value;
	}

	public int getSize()
	{
		return _data.length;
	}

	public byte[] getData()
	{
		return _data;
	}

	public String getName()
	{
		return _name;
	}
}
