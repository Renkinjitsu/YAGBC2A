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

package open_source.amuyal_tal.yagbc2a.core.object;

import open_source.amuyal_tal.yagbc2a.language.instruction.InstructionTemplate;
import open_source.amuyal_tal.yagbc2a.parsing.SourceLine;

public final class UnresolvedSymbol
{
	private final String _symbolName;
	private final int _startIndex;
	private final int _size;
	private final SourceLine _sourceLine;
	private final InstructionTemplate _instruction;
	private final int _operandIndex;

	public UnresolvedSymbol(
			final String symbolName,
			final int startIndex,
			final int size,
			final SourceLine sourceLine,
			final InstructionTemplate instruction,
			final int operandIndex
			)
	{
		_symbolName = symbolName;
		_startIndex = startIndex;
		_size = size;
		_sourceLine = sourceLine;
		_instruction = instruction;
		_operandIndex = operandIndex;
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

	public InstructionTemplate getInstruction()
	{
		return _instruction;
	}

	public int getOperandIndex()
	{
		return _operandIndex;
	}
}
