package open_source.amuyal_tal.yagbc2a.utils;


public class BytesArray
{
	private final class SubArray extends BytesArray
	{
		private final int _startIndex;
		private final int _length;

		public SubArray(
				final BytesArray bytesArray,
				final int startIndex,
				final int length
				)
		{
			super(bytesArray._bytes);

			_startIndex = startIndex;
			_length = length;
		}

		@Override
		public byte getAt(
				final int index
				)
		{
			return super.getAt(_startIndex + index);
		}

		@Override
		public void setAt(
				final int index,
				final byte value
				)
		{
			super.setAt(_startIndex + index, value);
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
			Utils.abort("Ilegal instruction");
		}

		@Override
		public void append(
				final BytesArray other
				)
		{
			Utils.abort("Ilegal instruction");
		}

		@Override
		public BytesArray getSubArray(
				final int startIndex,
				final int length
				)
		{
			Utils.abort("Ilegal instruction");
			return null;
		}

		@Override
		public BytesArray getSubArray(
				final int startIndex
				)
		{
			Utils.abort("Ilegal instruction");
			return null;
		}
	}

	private byte[] _bytes;

	public BytesArray()
	{
		this(new byte[0]);
	}

	public BytesArray(
			final byte[] bytes
			)
	{
		_bytes = bytes;
	}

	public byte getAt(
			final int index
			)
	{
		return _bytes[index];
	}

	public void setAt(
			final int index,
			final byte value
			)
	{
		_bytes[index] = value;
	}

	public int getSize()
	{
		return _bytes.length;
	}

	public void append(
			final byte value
			)
	{
		final byte[] old = _bytes;

		_bytes = new byte[_bytes.length + 1];

		for(int i = 0; i < old.length; i++)
		{
			_bytes[i] = old[i];
		}

		_bytes[_bytes.length - 1] = value;
	}

	public void append(
			final byte[] data
			)
	{
		final byte[] old = _bytes;

		_bytes = new byte[_bytes.length + data.length];

		for(int i = 0; i < old.length; i++)
		{
			_bytes[i] = old[i];
		}

		for(int i = 0; i < data.length; i++)
		{
			_bytes[old.length + i] = data[i];
		}
	}

	public void append(
			final BytesArray other
			)
	{
		append(other._bytes);
	}

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

	public BytesArray getSubArray(
			final int startIndex,
			final int length
			)
	{
		return new SubArray(this, startIndex, length);
	}

	public BytesArray getSubArray(
			final int startIndex
			)
	{
		final int length = _bytes.length - startIndex;

		return getSubArray(startIndex, length);
	}
}
