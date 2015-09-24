package open_source.amuyal_tal.yagbc2a;


public final class CommandTokens
{
	private final String _command;
	private final String[] _args;

	public CommandTokens(final String text) throws SyntaxException
	{
		if(text.contains(",,") || text.endsWith(","))
		{
			throw new SyntaxException(Syntax.Error.MISSING_PARAMETER_VALUE);
		}

		final String[] tokens = text.split(" ");
		if(tokens.length != 1 && tokens.length != 2)
		{
			throw new SyntaxException(Syntax.Error.TOO_MANY_SYMBOLS);
		}

		_command = tokens[0];
		_args = (tokens.length == 1) ? null : tokens[1].split(",");
	}

	public String getCommand()
	{
		return _command;
	}

	public int getArgumentsCount()
	{
		return (_args == null) ? 0 : _args.length;
	}

	public String getArgument(final int id)
	{
		return _args[id];
	}

	public void replaceArgument(
			final int index,
			final String newValue
			)
	{
		_args[index] = newValue;
	}

	@Override
	public String toString()
	{
		String string = _command;

		String args = "";

		for(final String arg : _args)
		{
			if(arg.isEmpty())
			{
				args = arg;
			}
			else
			{
				args += "," + arg;
			}
		}

		if(args.isEmpty() == false)
		{
			string += " " + args;
		}

		return string;
	}
}
