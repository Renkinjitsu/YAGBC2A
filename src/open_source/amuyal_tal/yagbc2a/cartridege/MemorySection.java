package open_source.amuyal_tal.yagbc2a.cartridege;

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
