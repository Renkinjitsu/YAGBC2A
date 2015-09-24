package open_source.amuyal_tal.yagbc2a.data;

import open_source.amuyal_tal.yagbc2a.utils.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.Utils;


public class PointerValueWithOffset extends InstructionParameter implements PointerType
{
	private final InstructionParameter _pointingParameter;

	public PointerValueWithOffset(final InstructionParameter pointingParameter)
	{
		super(pointingParameter.getName() + "+" + "r8");

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
		final String[] parts = string.split("\\+");

		boolean result;

		if(parts.length != 2)
		{
			result = false;
		}
		else if(parts[0].equalsIgnoreCase(_pointingParameter.getName()) == false)
		{
			result = false;
		}
		else
		{
			result = Utils.isSignedByte(parts[1]);
		}

		return result;
	}

	@Override
	public int getCodeSize()
	{
		return _pointingParameter.getCodeSize() + 1;
	}

	@Override
	public BytesArray assemble(final String string)
	{
		final BytesArray code = new BytesArray();
		final String[] parts = string.split("\\+");

		final BytesArray pointingParameterCode = _pointingParameter.assemble(parts[0]);
		if(pointingParameterCode != null)
		{
			code.append(pointingParameterCode);
		}

		try
		{
			final int value = Integer.parseInt(parts[1]);
			code.append((byte)value);
		}
		catch(final NumberFormatException ex)
		{
			Utils.abort(ex);
		}

		return code;
	}
}
