package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;


public class PointerValue extends InstructionParameter implements PointerType
{
	private final InstructionParameter _pointingParameter;

	public PointerValue(final InstructionParameter pointingParameter)
	{
		super(String.format("(%s)", pointingParameter.getName()));

		_pointingParameter = pointingParameter;
	}

	@Override
	public InstructionParameter getPointingParameter()
	{
		return _pointingParameter;
	}

	@Override
	public boolean matches(final String string)
	{
		return (string.length() > 2) &&
				(string.charAt(0) == '(') &&
				(string.charAt(string.length() -1) == ')') &&
				_pointingParameter.matches(getPointingPart(string));
	}

	@Override
	public int getCodeSize()
	{
		return _pointingParameter.getCodeSize();
	}

	@Override
	public BytesArray assemble(final String string)
	{
		return _pointingParameter.assemble(getPointingPart(string));
	}

	private static String getPointingPart(final String string)
	{
		return string.substring(1, string.length() - 1);
	}
}
