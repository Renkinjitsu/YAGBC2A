package open_source.amuyal_tal.yagbc2a;

public class InternalErrorException extends Exception
{
	public InternalErrorException(
			final Throwable throwable
			)
	{
		super("Internal error", throwable);
	}
}
