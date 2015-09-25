package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;

public abstract class InstructionParameter
{
	private final String _name;

	public InstructionParameter(final String name)
	{
		_name = name;
	}

	public abstract int getCodeSize();

	final public String getName()
	{
		return _name;
	}

	@Override
	public boolean equals(final Object obj)
	{
		final InstructionParameter other = (InstructionParameter)obj;

		return _name.equals(other._name);
	}

	public abstract boolean matches(final String string);

	public abstract BytesArray assemble(final String string);

//TODO: Implement (disassemble)
/*
	public abstract String disassemble(final byte[] machineCode);
*/
}
