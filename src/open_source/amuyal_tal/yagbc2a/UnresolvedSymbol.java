package open_source.amuyal_tal.yagbc2a;

final class UnresolvedSymbol
{
	private final String _symbolName;
	private final int _startIndex;
	private final int _size;
	private final SourceLine _sourceLine;

	public UnresolvedSymbol(
			final String symbolName,
			final int startIndex,
			final int size,
			final SourceLine sourceLine
			)
	{
		_symbolName = symbolName;
		_startIndex = startIndex;
		_size = size;
		_sourceLine = sourceLine;
	}

	public String getSymbolName()
	{
		return _symbolName;
	}

	public int getStartIndex()
	{
		return _startIndex;
	}

	public int getSize()
	{
		return _size;
	}

	public SourceLine getSourceLine()
	{
		return _sourceLine;
	}
}
