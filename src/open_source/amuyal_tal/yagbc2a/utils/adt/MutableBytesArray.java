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
