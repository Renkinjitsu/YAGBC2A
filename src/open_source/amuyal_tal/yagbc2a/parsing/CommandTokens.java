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
			if(args.isEmpty())
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
