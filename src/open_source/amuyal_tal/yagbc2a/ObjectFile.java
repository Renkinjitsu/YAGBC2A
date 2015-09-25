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
