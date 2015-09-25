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

package open_source.amuyal_tal.yagbc2a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class SourceFile implements Iterable<SourceLine>
{
	public final Queue<SourceLine> _lines;

	public SourceFile()
	{
		_lines = new LinkedBlockingQueue<SourceLine>();
	}

	public void readFile(
			final String filePath
			)
					throws HandledException
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(new File(filePath)));

			int lineNumber = 1;
			for(String line; (line = br.readLine()) != null; lineNumber++)
			{
				_lines.add(new SourceLine(line, filePath, lineNumber));
			}
		}
		catch(final Throwable throwable)
		{
			Utils.displayError(throwable);

			throw new HandledException();
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch(final Throwable throwable)
				{
					throw new HandledException();
				}
			}
		}
	}

	@Override
	public Iterator<SourceLine> iterator()
	{
		return _lines.iterator();
	}
}
