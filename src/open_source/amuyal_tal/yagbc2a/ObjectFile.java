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

package open_source.amuyal_tal.yagbc2a;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.adt.MutableBytesArray;
import open_source.amuyal_tal.yagbc2a.utils.adt.SubBytesArray;

public final class ObjectFile
{
	private final SymbolTable _symbolTable;
	private final BytesArray _code;
	private final BytesArray _data;

	public ObjectFile()
	{
		_symbolTable = new SymbolTable();
		_code = new MutableBytesArray();
		_data = new MutableBytesArray();
	}

	public int appendCode(final BytesArray code)
	{
		final int address = _code.getSize();

		_code.append(code);

		return address;
	}

	public SymbolTable getSymbolTable()
	{
		return _symbolTable;
	}

	public BytesArray getCodeSegmentSection(
			final int offset,
			final int size
			)
	{
		return new SubBytesArray(
				_code,
				offset,
				size
				);
	}

	public BytesArray getDataSegmentSection(
			final int offset,
			final int size
			)
	{
		return new SubBytesArray(
				_data,
				offset,
				size
				);
	}

	public int getCodeSegmentSize()
	{
		return _code.getSize();
	}

	public int getDataSegmentSize()
	{
		return _data.getSize();
	}

	public void appendCodeSegment(
			final byte code
			)
	{
		_data.append(code);
	}

	public void appendDataSegment(
			final byte data
			)
	{
		_data.append(data);
	}

	public void setCodeSegmentSection(
			final int startIndex,
			final byte[] data
			)
	{
		_code.override(startIndex, data);
	}
}
