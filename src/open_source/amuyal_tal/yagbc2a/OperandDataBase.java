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

import open_source.amuyal_tal.yagbc2a.language.operand.ConstantNumberOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.FlagConditionOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.ImmediateNumberOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.Operand;
import open_source.amuyal_tal.yagbc2a.language.operand.PointerOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.PointerOperandWithOffset;
import open_source.amuyal_tal.yagbc2a.language.operand.RegisterOperand;
import open_source.amuyal_tal.yagbc2a.language.operand.RegisterOperand.RegisterBitCount;

public final class OperandDataBase
{
	private OperandDataBase()
	{
		//Static class
	}

	private static final List<Operand> _database;

	static
	{
		_database = new LinkedList<Operand>();

		{
			final Operand d8 = new ImmediateNumberOperand("d8", false, true, true);
			final Operand d16 = new ImmediateNumberOperand("d16", false, true, false);
			final Operand a8 = new ImmediateNumberOperand("a8", false, false, true);
			final Operand a16 = new ImmediateNumberOperand("a16", false, false, false);
			final Operand r8 = new ImmediateNumberOperand("r8", true, true, true);

			_database.add(d8);
			_database.add(d16);
			_database.add(a8);
			_database.add(a16);
			_database.add(r8);

			_database.add(new PointerOperand(d8));
			_database.add(new PointerOperand(d16));
			_database.add(new PointerOperand(a8));
			_database.add(new PointerOperand(a16));
			_database.add(new PointerOperand(r8));
		}

		{
			final RegisterOperand A = new RegisterOperand("A", RegisterBitCount.EIGHT, true);
			final RegisterOperand B = new RegisterOperand("B", RegisterBitCount.EIGHT, true);
			final RegisterOperand C = new RegisterOperand("C", RegisterBitCount.EIGHT, true);
			final RegisterOperand D = new RegisterOperand("D", RegisterBitCount.EIGHT, true);
			final RegisterOperand E = new RegisterOperand("E", RegisterBitCount.EIGHT, true);
			final RegisterOperand H = new RegisterOperand("H", RegisterBitCount.EIGHT, true);
			final RegisterOperand L = new RegisterOperand("L", RegisterBitCount.EIGHT, true);
			final RegisterOperand F = new RegisterOperand("F", RegisterBitCount.EIGHT, false);
			final RegisterOperand SP = new RegisterOperand("SP", RegisterBitCount.SIXTEEN, true);
			final RegisterOperand PC = new RegisterOperand("PC", RegisterBitCount.SIXTEEN, true);

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

			_database.add(new PointerOperand(A));
			_database.add(new PointerOperand(B));
			_database.add(new PointerOperand(C));
			_database.add(new PointerOperand(D));
			_database.add(new PointerOperand(E));
			_database.add(new PointerOperand(H));
			_database.add(new PointerOperand(L));
			_database.add(new PointerOperand(F));
			_database.add(new PointerOperand(SP));
			_database.add(new PointerOperand(PC));

			_database.add(new PointerOperandWithOffset(SP));
		}

		{
			final RegisterOperand HL = new RegisterOperand("HL", RegisterBitCount.SIXTEEN, true);
			final RegisterOperand AF = new RegisterOperand("AF", RegisterBitCount.SIXTEEN, false);
			final RegisterOperand BC = new RegisterOperand("BC", RegisterBitCount.SIXTEEN, true);
			final RegisterOperand DE = new RegisterOperand("DE", RegisterBitCount.SIXTEEN, true);

			_database.add(HL);
			_database.add(AF);
			_database.add(BC);
			_database.add(DE);

			_database.add(new PointerOperand(HL));
			_database.add(new PointerOperand(AF));
			_database.add(new PointerOperand(BC));
			_database.add(new PointerOperand(DE));
		}

		{
			final ConstantNumberOperand hex_00 = new ConstantNumberOperand("00H");
			final ConstantNumberOperand hex_08 = new ConstantNumberOperand("08H");
			final ConstantNumberOperand hex_10 = new ConstantNumberOperand("10H");
			final ConstantNumberOperand hex_18 = new ConstantNumberOperand("18H");
			final ConstantNumberOperand hex_20 = new ConstantNumberOperand("20H");
			final ConstantNumberOperand hex_28 = new ConstantNumberOperand("28H");
			final ConstantNumberOperand hex_30 = new ConstantNumberOperand("30H");
			final ConstantNumberOperand hex_38 = new ConstantNumberOperand("38H");

			final ConstantNumberOperand dec_0 = new ConstantNumberOperand("0");
			final ConstantNumberOperand dec_1 = new ConstantNumberOperand("1");
			final ConstantNumberOperand dec_2 = new ConstantNumberOperand("2");
			final ConstantNumberOperand dec_3 = new ConstantNumberOperand("3");
			final ConstantNumberOperand dec_4 = new ConstantNumberOperand("4");
			final ConstantNumberOperand dec_5 = new ConstantNumberOperand("5");
			final ConstantNumberOperand dec_6 = new ConstantNumberOperand("6");
			final ConstantNumberOperand dec_7 = new ConstantNumberOperand("7");

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
			final FlagConditionOperand NZ = new FlagConditionOperand("NZ");
			final FlagConditionOperand Z = new FlagConditionOperand("Z");
			final FlagConditionOperand NC = new FlagConditionOperand("NC");

			_database.add(NZ);
			_database.add(Z);
			_database.add(NC);
		}
	}

	public static final Operand searchByName(final String parameterName)
	{
		for(final Operand parameter : _database)
		{
			if(parameter.getName().equals(parameterName))
			{
				return parameter;
			}
		}

		return null;
	}
}
