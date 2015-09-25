package open_source.amuyal_tal.yagbc2a.utils.adt;


public abstract class BytesArray
{
	public abstract byte getAt(
			final int index
			);

	public abstract void setAt(
			final int index,
			final byte value
			);

	public abstract int getSize(
			);

	public abstract void append(
			final byte value
			);

	public abstract void append(
			final byte[] bytes
			);

	public abstract void append(
			final BytesArray other
			);

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

	public void override(
			final int startIndex,
			final byte[] bytes
			)
	{
		for(int i = 0; i < bytes.length; i++)
		{
			setAt(startIndex + i, bytes[i]);
		}
	}

	@Override
	public String toString()
	{
		String string = "";

		for(int i = 0; i < getSize(); i++)
		{
			final char ch = (char)getAt(i);

			if(ch == '\0')
			{
				break;
			}
			else
			{
				string += ch;
			}
		}

		return string;
	}
}
