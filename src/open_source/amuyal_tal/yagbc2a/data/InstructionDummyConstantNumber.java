package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.Utils;
import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public final class InstructionDummyConstantNumber extends InstructionParameter
{
	private final int _integerValue;

	public InstructionDummyConstantNumber(
			final String value
			)
	{
		super(value);

		_integerValue = Utils.parseValue(value);
	}

	@Override
	public boolean matches(final String string)
	{
		boolean match = false;

		if(string.length() > 0)
		{
			try
			{
				match = (Utils.parseValue(string) == _integerValue);
			}
			catch(final NumberFormatException ex)
			{
				//`match` already set
			}
		}

		return match;
	}

	public int getValue()
	{
		return _integerValue;
	}

	@Override
	public int getCodeSize()
	{
		return 0;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		return null;
	}
}
