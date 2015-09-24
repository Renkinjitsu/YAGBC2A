package open_source.amuyal_tal.yagbc2a;

public class SourceLine
{
	private final String _fileName;
	private final int _lineNumber;

	private String _content; //transformed

	public SourceLine(
			final String text,
			final String filneName,
			final int lineNumber
			)
	{
		_fileName = filneName;
		_lineNumber = lineNumber;

		_content = text;
		//Remove comments
		{
			final String[] splitLine = _content.split(Syntax.COMMENT_SYMBOL);
			_content = splitLine[0];
		}

		//Remove white-spaces
		{
			_content = _content.replace('\t', ' ');

			while(_content.contains("  "))
			{
				_content = _content.replace("  ", " ");
			}

			_content = _content.replace(": ", ":");
			_content = _content.replace(" :", ":");

			_content = _content.replace(", ", ",");
			_content = _content.replace(" ,", ",");

			_content = _content.replace("+ ", "+");
			_content = _content.replace(" +", "+");

			_content = _content.replace("- ", "-");
			_content = _content.replace(" -", "-");

			_content = _content.replace("( ", "(");
			_content = _content.replace(" )", ")");

			_content = _content.trim();
		}
	}

	public String getText()
	{
		return _content;
	}

	public void resetText(final String newText)
	{
		_content = newText;
	}

	public boolean isEmpty()
	{
		return _content.isEmpty();
	}

	public String getFileName()
	{
		return _fileName;
	}

	public int getLineNumber()
	{
		return _lineNumber;
	}
}
