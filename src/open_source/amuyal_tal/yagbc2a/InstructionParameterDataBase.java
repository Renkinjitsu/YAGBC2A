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

import java.util.LinkedList;
import java.util.List;

import open_source.amuyal_tal.yagbc2a.data.InstructionDummyConstantNumber;
import open_source.amuyal_tal.yagbc2a.data.InstructionFlagCondition;
import open_source.amuyal_tal.yagbc2a.data.InstructionImmediateNumberTemplate;
import open_source.amuyal_tal.yagbc2a.data.InstructionParameter;
import open_source.amuyal_tal.yagbc2a.data.PointerValue;
import open_source.amuyal_tal.yagbc2a.data.PointerValueWithOffset;
import open_source.amuyal_tal.yagbc2a.data.Register;
import open_source.amuyal_tal.yagbc2a.data.Register.RegisterBitCount;

public final class InstructionParameterDataBase
{
	private InstructionParameterDataBase()
	{
		//Static class
	}

	private static final List<InstructionParameter> _database;

	static
	{
		_database = new LinkedList<InstructionParameter>();

		{
			final InstructionParameter d8 = new InstructionImmediateNumberTemplate("d8", false, true, true);
			final InstructionParameter d16 = new InstructionImmediateNumberTemplate("d16", false, true, false);
			final InstructionParameter a8 = new InstructionImmediateNumberTemplate("a8", false, false, true);
			final InstructionParameter a16 = new InstructionImmediateNumberTemplate("a16", false, false, false);
			final InstructionParameter r8 = new InstructionImmediateNumberTemplate("r8", false, true, true);

			_database.add(d8);
			_database.add(d16);
			_database.add(a8);
			_database.add(a16);
			_database.add(r8);

			_database.add(new PointerValue(d8));
			_database.add(new PointerValue(d16));
			_database.add(new PointerValue(a8));
			_database.add(new PointerValue(a16));
			_database.add(new PointerValue(r8));
		}

		{
			final Register A = new Register("A", RegisterBitCount.EIGHT, true);
			final Register B = new Register("B", RegisterBitCount.EIGHT, true);
			final Register C = new Register("C", RegisterBitCount.EIGHT, true);
			final Register D = new Register("D", RegisterBitCount.EIGHT, true);
			final Register E = new Register("E", RegisterBitCount.EIGHT, true);
			final Register H = new Register("H", RegisterBitCount.EIGHT, true);
			final Register L = new Register("L", RegisterBitCount.EIGHT, true);
			final Register F = new Register("F", RegisterBitCount.EIGHT, false);
			final Register SP = new Register("SP", RegisterBitCount.SIXTEEN, true);
			final Register PC = new Register("PC", RegisterBitCount.SIXTEEN, true);

			_database.add(A);
			_database.add(B);
			_database.add(C);
			_database.add(D);
			_database.add(E);
			_database.add(H);
			_database.add(L);
			//_database.add(F);
			_database.add(SP);
			_database.add(PC);

			_database.add(new PointerValue(A));
			_database.add(new PointerValue(B));
			_database.add(new PointerValue(C));
			_database.add(new PointerValue(D));
			_database.add(new PointerValue(E));
			_database.add(new PointerValue(H));
			_database.add(new PointerValue(L));
			_database.add(new PointerValue(F));
			_database.add(new PointerValue(SP));
			_database.add(new PointerValue(PC));

			_database.add(new PointerValueWithOffset(SP));
		}

		{
			final Register HL = new Register("HL", RegisterBitCount.SIXTEEN, true);
			final Register AF = new Register("AF", RegisterBitCount.SIXTEEN, false);
			final Register BC = new Register("BC", RegisterBitCount.SIXTEEN, true);
			final Register DE = new Register("DE", RegisterBitCount.SIXTEEN, true);

			_database.add(HL);
			_database.add(AF);
			_database.add(BC);
			_database.add(DE);

			_database.add(new PointerValue(HL));
			_database.add(new PointerValue(AF));
			_database.add(new PointerValue(BC));
			_database.add(new PointerValue(DE));
		}

		{
			final InstructionDummyConstantNumber hex_00 = new InstructionDummyConstantNumber("00H");
			final InstructionDummyConstantNumber hex_08 = new InstructionDummyConstantNumber("08H");
			final InstructionDummyConstantNumber hex_10 = new InstructionDummyConstantNumber("10H");
			final InstructionDummyConstantNumber hex_18 = new InstructionDummyConstantNumber("18H");
			final InstructionDummyConstantNumber hex_20 = new InstructionDummyConstantNumber("20H");
			final InstructionDummyConstantNumber hex_28 = new InstructionDummyConstantNumber("28H");
			final InstructionDummyConstantNumber hex_30 = new InstructionDummyConstantNumber("30H");
			final InstructionDummyConstantNumber hex_38 = new InstructionDummyConstantNumber("38H");

			final InstructionDummyConstantNumber dec_0 = new InstructionDummyConstantNumber("0");
			final InstructionDummyConstantNumber dec_1 = new InstructionDummyConstantNumber("1");
			final InstructionDummyConstantNumber dec_2 = new InstructionDummyConstantNumber("2");
			final InstructionDummyConstantNumber dec_3 = new InstructionDummyConstantNumber("3");
			final InstructionDummyConstantNumber dec_4 = new InstructionDummyConstantNumber("4");
			final InstructionDummyConstantNumber dec_5 = new InstructionDummyConstantNumber("5");
			final InstructionDummyConstantNumber dec_6 = new InstructionDummyConstantNumber("6");
			final InstructionDummyConstantNumber dec_7 = new InstructionDummyConstantNumber("7");

			_database.add(hex_00);
			_database.add(hex_08);
			_database.add(hex_10);
			_database.add(hex_18);
			_database.add(hex_20);
			_database.add(hex_28);
			_database.add(hex_30);
			_database.add(hex_38);

			_database.add(dec_0);
			_database.add(dec_1);
			_database.add(dec_2);
			_database.add(dec_3);
			_database.add(dec_4);
			_database.add(dec_5);
			_database.add(dec_6);
			_database.add(dec_7);
		}

		{
			final InstructionFlagCondition NZ = new InstructionFlagCondition("NZ");
			final InstructionFlagCondition Z = new InstructionFlagCondition("Z");
			final InstructionFlagCondition NC = new InstructionFlagCondition("NC");

			_database.add(NZ);
			_database.add(Z);
			_database.add(NC);
		}
	}

	public static final InstructionParameter searchByName(final String parameterName)
	{
		for(final InstructionParameter parameter : _database)
		{
			if(parameter.getName().equals(parameterName))
			{
				return parameter;
			}
		}

		return null;
	}
}
