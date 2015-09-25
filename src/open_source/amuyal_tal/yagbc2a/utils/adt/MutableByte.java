package open_source.amuyal_tal.yagbc2a.utils.adt;

public final class MutableByte
{
	private byte _value;

	public MutableByte()
	{
		this((byte)0); //Use 0 as default value
	}

	public MutableByte(final byte initialValue)
	{
		_value = initialValue;
	}

	public byte getValue()
	{
		return _value;
	}

	public void setValue(final byte newValue)
	{
		_value = newValue;
	}
}
