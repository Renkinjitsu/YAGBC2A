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

import java.util.HashMap;
import java.util.Map;

import open_source.amuyal_tal.yagbc2a.utils.Utils;

public final class SymbolTable
{
	public final class VariableSymbol
	{
		private final int _address;
		private final int _size;

		private VariableSymbol(
				final int address,
				final int size
				)
		{
			_address = address;
			_size = size;
		}

		public int getAddress()
		{
			return _address;
		}

		public int getSize()
		{
			return _size;
		}
	}

	private final Map<String, Integer> _symbolicLabels;
	private final Map<String, VariableSymbol> _symbolicVariables;

	public SymbolTable()
	{
		_symbolicLabels = new HashMap<String, Integer>();
		_symbolicVariables = new HashMap<String, VariableSymbol>();
	}

	public void defineSymbolicLabel(
			final String name,
			final int address
			)
	{
		_symbolicLabels.put(name, new Integer(address));
	}

	public int getSymbolicLabelAddress(
			final String name
			)
	{
		final Integer value = _symbolicLabels.get(name);
		if(value == null)
		{
			Utils.abort("!! INTERNAL ERROR !! symbol not found");
		}

		return value.intValue();
	}

	public boolean isSymbolicLabelDefined(
			final String name
			)
	{
		return _symbolicLabels.containsKey(name);
	}

	public void defineSymbolicVariable(
			final String name,
			final int address,
			final int size
			)
	{
		_symbolicVariables.put(name, new VariableSymbol(address, size));
	}

	public VariableSymbol getSymbolicVariable(
			final String name
			)
	{
		final VariableSymbol variable = _symbolicVariables.get(name);
		if(variable == null)
		{
			Utils.abort("!! INTERNAL ERROR !! symbol not found");
		}

		return variable;
	}

	public boolean isSymbolicVariableDefined(
			final String name
			)
	{
		return _symbolicVariables.containsKey(name);
	}

	public boolean isSymbolDefined(
			final String symbolName
			)
	{
		return _symbolicLabels.containsKey(symbolName) ||
				_symbolicVariables.containsKey(symbolName);
	}
}
