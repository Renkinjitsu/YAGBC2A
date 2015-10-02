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

package open_source.amuyal_tal.yagbc2a.object;

import java.util.HashMap;
import java.util.Map;

import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class SymbolTable
{
	private final Map<String, Symbol> _symbols;

	public SymbolTable()
	{
		_symbols = new HashMap<String, Symbol>();
	}

	public void insert(
			final String name,
			final Symbol symbol
			)
	{
		_symbols.put(
				name,
				symbol
				);
	}

	public Symbol getSymbol(
			final String name
			)
	{
		final Symbol symbol = _symbols.get(name);
		if(symbol == null)
		{
			Utils.abort("!! INTERNAL ERROR !! symbol not found");
		}

		return symbol;
	}

	public boolean isSymbolDefined(
			final String symbolName
			)
	{
		return _symbols.containsKey(symbolName);
	}
}
