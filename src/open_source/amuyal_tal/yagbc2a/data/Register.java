package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public class Register extends InstructionParameter
{
	public enum RegisterBitCount
	{
		EIGHT(8),
		SIXTEEN(16);

		private final int _bits;

		private RegisterBitCount(final int bits)
		{
			_bits = bits;
		}

		public int getValue()
		{
			return _bits;
		}
	}

	private final RegisterBitCount _registerBitCount;
	private final boolean _isWritable;

	public Register(
			final String name,
			final RegisterBitCount registerBitCount,
			final boolean isWritable
			)
	{
		super(name);

		_registerBitCount = registerBitCount;
		_isWritable = isWritable;
	}

	public RegisterBitCount getRegisterBitCount()
	{
		return _registerBitCount;
	}

	public boolean isWritable()
	{
		return _isWritable;
	}

	@Override
	public boolean matches(final String string)
	{
		return (getName().equalsIgnoreCase(string));
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
