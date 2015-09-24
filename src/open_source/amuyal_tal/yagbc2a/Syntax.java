package open_source.amuyal_tal.yagbc2a;

public final class Syntax
{
	public static final String COMMENT_SYMBOL = ";";

	public static final int ADDRESS_CODE_START = 0x0100;
	public static final int ADDRESS_STACK_POINTER_DEFAULT = 0x0FFE;

	public final class Error
	{
		public static final String MISSING_PARAMETER_VALUE = "Missing parameter value";
		public static final String TOO_MANY_SYMBOLS = "Too many symbols";
		public static final String TOO_MANY_ARGUMENSTS = "Too many arguments";
		public static final String TOO_LITTLE_ARGUMENTS = "Too little arguments";
	}
}
