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

package open_source.amuyal_tal.yagbc2a.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class AddressAssignables
{
	private final LinkedList<AddressAssignable> _addressless;

	public AddressAssignables()
	{
		_addressless = new LinkedList<AddressAssignable>();
	}

	public void addAll(
			final Collection<? extends AddressAssignable> addressless
			)
	{
		_addressless.addAll(addressless);
	}

	/**
	 * Sort elements by line-number of deceleration
	 */
	public void sort()
	{
		_addressless.sort(
				new Comparator<AddressAssignable>()
				{
					@Override
					public int compare(
							final AddressAssignable o1,
							final AddressAssignable o2
							)
					{
						return o1.getDecelerationLineNumber() - o2.getDecelerationLineNumber();
					}
				}
				);
	}

	public void assignAddress(
			final int sourceLineNumber,
			final int address
			)
	{
		final Iterator<AddressAssignable> iterator = _addressless.iterator();

		while(iterator.hasNext())
		{
			final AddressAssignable addressless = iterator.next();

			if(sourceLineNumber >= addressless.getDecelerationLineNumber())
			{
				addressless.assignAddress(
						address
						);

				iterator.remove();
			}
			else
			{
				/*
				 * Address-less are sorted by line number, thus, a performance gain is achieved
				 *  by aborting the search on the first mismatch.
				 */
				return;
			}
		}
	}

	public void assignRemaining(
			final int address
			)
	{
		for(final AddressAssignable addressless : _addressless)
		{
			addressless.assignAddress(
					address
					);
		}

		_addressless.clear();
	}
}
