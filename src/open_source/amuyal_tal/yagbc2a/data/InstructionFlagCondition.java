package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public final class InstructionFlagCondition extends InstructionParameter
{
	public InstructionFlagCondition(final String name)
	{
		super(name);
	}

	@Override
	public boolean matches(final String string)
	{
		return getName().equalsIgnoreCase(string);
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
