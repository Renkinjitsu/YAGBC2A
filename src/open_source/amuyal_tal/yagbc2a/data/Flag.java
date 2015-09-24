package open_source.amuyal_tal.yagbc2a.data;

public enum Flag
{
	ZERO(0),
	NEGATIVE(1),
	HALF_CARRY(2),
	CARRY(3);

	private final int _index;

	private Flag(final int index)
	{
		_index = index;
	}

	public int getIndex()
	{
		return _index;
	}
}
