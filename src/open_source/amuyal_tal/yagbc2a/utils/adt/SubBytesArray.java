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
