package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class InstructionImmediateNumberTemplate extends InstructionParameter
{
	private final boolean _isSigned;
	private final boolean _isImmediate;
	private final boolean _isEightBit;
	private final boolean _isAddress;

	public InstructionImmediateNumberTemplate(
			final String name,
			final boolean isSigned,
			final boolean isImmediate,
			final boolean isEightBit
			)
	{
		super(name);

		_isSigned = isSigned;
		_isImmediate = isImmediate;
		_isEightBit = isEightBit;
		_isAddress = (name.charAt(0) == 'a');
	}

	public boolean isSigned()
	{
		return _isSigned;
	}

	public boolean isImmediate()
	{
		return _isImmediate;
	}

	public boolean isEightBit()
	{
		return _isEightBit;
	}

	public boolean isAddress()
	{
		return _isAddress;
	}

	private boolean isInValidRange(final int value)
	{
		boolean result;

		if(isEightBit())
		{
			if(isSigned())
			{
				result = (-128 <= value) && (value <= 127);
			}
			else
			{
				result = (0 <= value) && (value <= 255);
			}
		}
		else
		{
			if(isSigned())
			{
				result = (-32768 <= value) && (value <= 32767);
			}
			else
			{
				result = (0 <= value) && (value <= 65535);
			}
		}

		return result;
	}

	@Override
	public boolean matches(final String string)
	{
		boolean result;

		try
		{
			final int value = Utils.parseValue(string);
			result = isInValidRange(value);
		}
		catch(final NumberFormatException ex)
		{
			result = false;
		}

		return result;
	}

	@Override
	public int getCodeSize()
	{
		return isEightBit() ? 1 : 2;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		final BytesArray code = new BytesArray();

		final int value = Utils.parseValue(string);

		//TODO: Verify (and probably fix) for negative numbers
		if(isEightBit())
		{
			code.append((byte)value);
		}
		else
		{
			//Set in a little-endian layout
			code.append((byte)(value & 0xFF));
			code.append((byte)(value >> 8));
		}

		return code;
	}
}
