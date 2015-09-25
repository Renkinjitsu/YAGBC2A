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
