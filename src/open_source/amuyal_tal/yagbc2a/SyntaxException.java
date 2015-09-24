package open_source.amuyal_tal.yagbc2a;

public class SyntaxException extends Exception
{
	public SyntaxException(
			final String message
			)
	{
		super(message, new Throwable(message));
	}
}
