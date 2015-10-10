/*
    Yet Another Gameboy Classic/Color Assembler (YAGBC2A) can compile Gameboy-compatible images.
    Copyright (C) 2015  Tal Amuyal

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

	Contact information (email): TalAmuyal@gmail.com
*/

package open_source.amuyal_tal.yagbc2a.parsing;

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
