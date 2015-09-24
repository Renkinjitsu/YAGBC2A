package open_source.amuyal_tal.yagbc2a;

import java.util.LinkedList;
import java.util.List;

import open_source.amuyal_tal.yagbc2a.data.InstructionParameter;
import open_source.amuyal_tal.yagbc2a.instruction.FlagInfluance;
import open_source.amuyal_tal.yagbc2a.instruction.InstructionTemplate;

public final class InstructionDataBase
{
	private InstructionDataBase()
	{
		//Static class
	}

	private static final List<InstructionTemplate> _database;

	static
	{
		_database = new LinkedList<InstructionTemplate>();

		_database.add(new InstructionTemplate(0x00, "NOP", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		_database.add(new InstructionTemplate(0x01, "LD", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "BC,d16"));
		_database.add(new InstructionTemplate(0x02, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(BC),A"));
		_database.add(new InstructionTemplate(0x03, "INC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "BC"));
		_database.add(new InstructionTemplate(0x04, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "B"));
		_database.add(new InstructionTemplate(0x05, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "B"));
		_database.add(new InstructionTemplate(0x06, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,d8"));
		_database.add(new InstructionTemplate(0x07, "RLCA", 4, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x08, "LD", 20, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(a16),SP"));
		_database.add(new InstructionTemplate(0x09, "ADD", 8, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "HL,BC"));
		_database.add(new InstructionTemplate(0x0A, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(BC)"));
		_database.add(new InstructionTemplate(0x0B, "DEC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "BC"));
		_database.add(new InstructionTemplate(0x0C, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "C"));
		_database.add(new InstructionTemplate(0x0D, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "C"));
		_database.add(new InstructionTemplate(0x0E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,d8"));
		_database.add(new InstructionTemplate(0x0F, "RRCA", 4, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x10, "STOP", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0"));
		_database.add(new InstructionTemplate(0x11, "LD", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "DE,d16"));
		_database.add(new InstructionTemplate(0x12, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(DE),A"));
		_database.add(new InstructionTemplate(0x13, "INC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "DE"));
		_database.add(new InstructionTemplate(0x14, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "D"));
		_database.add(new InstructionTemplate(0x15, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "D"));
		_database.add(new InstructionTemplate(0x16, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,d8"));
		_database.add(new InstructionTemplate(0x17, "RLA", 4, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x18, "JR", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "r8"));
		_database.add(new InstructionTemplate(0x19, "ADD", 8, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "HL,DE"));
		_database.add(new InstructionTemplate(0x1A, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(DE)"));
		_database.add(new InstructionTemplate(0x1B, "DEC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "DE"));
		_database.add(new InstructionTemplate(0x1C, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "E"));
		_database.add(new InstructionTemplate(0x1D, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "E"));
		_database.add(new InstructionTemplate(0x1E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,d8"));
		_database.add(new InstructionTemplate(0x1F, "RRA", 4, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x20, "JR", 12/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NZ,r8"));
		_database.add(new InstructionTemplate(0x21, "LD", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "HL,d16"));
		_database.add(new InstructionTemplate(0x22, "LDI", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),A"));
		_database.add(new InstructionTemplate(0x23, "INC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "HL"));
		_database.add(new InstructionTemplate(0x24, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "H"));
		_database.add(new InstructionTemplate(0x25, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "H"));
		_database.add(new InstructionTemplate(0x26, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,d8"));
		_database.add(new InstructionTemplate(0x27, "DAA", 4, FlagInfluance.COMPUTE, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x28, "JR", 12/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "Z,r8"));
		_database.add(new InstructionTemplate(0x29, "ADD", 8, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "HL,HL"));
		_database.add(new InstructionTemplate(0x2A, "LDI", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x2B, "DEC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "HL"));
		_database.add(new InstructionTemplate(0x2C, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "L"));
		_database.add(new InstructionTemplate(0x2D, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "L"));
		_database.add(new InstructionTemplate(0x2E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,d8"));
		_database.add(new InstructionTemplate(0x2F, "CPL", 4, FlagInfluance.NONE, FlagInfluance.ON, FlagInfluance.ON, FlagInfluance.NONE, ""));
		_database.add(new InstructionTemplate(0x30, "JR", 12/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NC,r8"));
		_database.add(new InstructionTemplate(0x31, "LD", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "SP,d16"));
		_database.add(new InstructionTemplate(0x32, "LDD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),A"));
		_database.add(new InstructionTemplate(0x33, "INC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "SP"));
		_database.add(new InstructionTemplate(0x34, "INC", 12, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "(HL)"));
		_database.add(new InstructionTemplate(0x35, "DEC", 12, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "(HL)"));
		_database.add(new InstructionTemplate(0x36, "LD", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),d8"));
		_database.add(new InstructionTemplate(0x37, "SCF", 4, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.ON, ""));
		_database.add(new InstructionTemplate(0x38, "JR", 12/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,r8"));
		_database.add(new InstructionTemplate(0x39, "ADD", 8, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "HL,SP"));
		_database.add(new InstructionTemplate(0x3A, "LDD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x3B, "DEC", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "SP"));
		_database.add(new InstructionTemplate(0x3C, "INC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.NONE, "A"));
		_database.add(new InstructionTemplate(0x3D, "DEC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.NONE, "A"));
		_database.add(new InstructionTemplate(0x3E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,d8"));
		_database.add(new InstructionTemplate(0x3F, "CCF", 4, FlagInfluance.NONE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, ""));
		_database.add(new InstructionTemplate(0x40, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,B"));
		_database.add(new InstructionTemplate(0x41, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,C"));
		_database.add(new InstructionTemplate(0x42, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,D"));
		_database.add(new InstructionTemplate(0x43, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,E"));
		_database.add(new InstructionTemplate(0x44, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,H"));
		_database.add(new InstructionTemplate(0x45, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,L"));
		_database.add(new InstructionTemplate(0x46, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,(HL)"));
		_database.add(new InstructionTemplate(0x47, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "B,A"));
		_database.add(new InstructionTemplate(0x48, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,B"));
		_database.add(new InstructionTemplate(0x49, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,C"));
		_database.add(new InstructionTemplate(0x4A, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,D"));
		_database.add(new InstructionTemplate(0x4B, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,E"));
		_database.add(new InstructionTemplate(0x4C, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,H"));
		_database.add(new InstructionTemplate(0x4D, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,L"));
		_database.add(new InstructionTemplate(0x4E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,(HL)"));
		_database.add(new InstructionTemplate(0x4F, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,A"));
		_database.add(new InstructionTemplate(0x50, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,B"));
		_database.add(new InstructionTemplate(0x51, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,C"));
		_database.add(new InstructionTemplate(0x52, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,D"));
		_database.add(new InstructionTemplate(0x53, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,E"));
		_database.add(new InstructionTemplate(0x54, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,H"));
		_database.add(new InstructionTemplate(0x55, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,L"));
		_database.add(new InstructionTemplate(0x56, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,(HL)"));
		_database.add(new InstructionTemplate(0x57, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "D,A"));
		_database.add(new InstructionTemplate(0x58, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,B"));
		_database.add(new InstructionTemplate(0x59, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,C"));
		_database.add(new InstructionTemplate(0x5A, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,D"));
		_database.add(new InstructionTemplate(0x5B, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,E"));
		_database.add(new InstructionTemplate(0x5C, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,H"));
		_database.add(new InstructionTemplate(0x5D, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,L"));
		_database.add(new InstructionTemplate(0x5E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,(HL)"));
		_database.add(new InstructionTemplate(0x5F, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "E,A"));
		_database.add(new InstructionTemplate(0x60, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,B"));
		_database.add(new InstructionTemplate(0x61, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,C"));
		_database.add(new InstructionTemplate(0x62, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,D"));
		_database.add(new InstructionTemplate(0x63, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,E"));
		_database.add(new InstructionTemplate(0x64, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,H"));
		_database.add(new InstructionTemplate(0x65, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,L"));
		_database.add(new InstructionTemplate(0x66, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,(HL)"));
		_database.add(new InstructionTemplate(0x67, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "H,A"));
		_database.add(new InstructionTemplate(0x68, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,B"));
		_database.add(new InstructionTemplate(0x69, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,C"));
		_database.add(new InstructionTemplate(0x6A, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,D"));
		_database.add(new InstructionTemplate(0x6B, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,E"));
		_database.add(new InstructionTemplate(0x6C, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,H"));
		_database.add(new InstructionTemplate(0x6D, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,L"));
		_database.add(new InstructionTemplate(0x6E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,(HL)"));
		_database.add(new InstructionTemplate(0x6F, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "L,A"));
		_database.add(new InstructionTemplate(0x70, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),B"));
		_database.add(new InstructionTemplate(0x71, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),C"));
		_database.add(new InstructionTemplate(0x72, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),D"));
		_database.add(new InstructionTemplate(0x73, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),E"));
		_database.add(new InstructionTemplate(0x74, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),H"));
		_database.add(new InstructionTemplate(0x75, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),L"));
		_database.add(new InstructionTemplate(0x76, "HALT", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		_database.add(new InstructionTemplate(0x77, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL),A"));
		_database.add(new InstructionTemplate(0x78, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,B"));
		_database.add(new InstructionTemplate(0x79, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,C"));
		_database.add(new InstructionTemplate(0x7A, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,D"));
		_database.add(new InstructionTemplate(0x7B, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,E"));
		_database.add(new InstructionTemplate(0x7C, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,H"));
		_database.add(new InstructionTemplate(0x7D, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,L"));
		_database.add(new InstructionTemplate(0x7E, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x7F, "LD", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,A"));
		_database.add(new InstructionTemplate(0x80, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,B"));
		_database.add(new InstructionTemplate(0x81, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,C"));
		_database.add(new InstructionTemplate(0x82, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,D"));
		_database.add(new InstructionTemplate(0x83, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,E"));
		_database.add(new InstructionTemplate(0x84, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,H"));
		_database.add(new InstructionTemplate(0x85, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,L"));
		_database.add(new InstructionTemplate(0x86, "ADD", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x87, "ADD", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,A"));
		_database.add(new InstructionTemplate(0x88, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,B"));
		_database.add(new InstructionTemplate(0x89, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,C"));
		_database.add(new InstructionTemplate(0x8A, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,D"));
		_database.add(new InstructionTemplate(0x8B, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,E"));
		_database.add(new InstructionTemplate(0x8C, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,H"));
		_database.add(new InstructionTemplate(0x8D, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,L"));
		_database.add(new InstructionTemplate(0x8E, "ADC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x8F, "ADC", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,A"));
		_database.add(new InstructionTemplate(0x90, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0x91, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0x92, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0x93, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0x94, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0x95, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0x96, "SUB", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0x97, "SUB", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0x98, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,B"));
		_database.add(new InstructionTemplate(0x99, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,C"));
		_database.add(new InstructionTemplate(0x9A, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,D"));
		_database.add(new InstructionTemplate(0x9B, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,E"));
		_database.add(new InstructionTemplate(0x9C, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,H"));
		_database.add(new InstructionTemplate(0x9D, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,L"));
		_database.add(new InstructionTemplate(0x9E, "SBC", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,(HL)"));
		_database.add(new InstructionTemplate(0x9F, "SBC", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,A"));
		_database.add(new InstructionTemplate(0xA0, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "B"));
		_database.add(new InstructionTemplate(0xA1, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "C"));
		_database.add(new InstructionTemplate(0xA2, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "D"));
		_database.add(new InstructionTemplate(0xA3, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "E"));
		_database.add(new InstructionTemplate(0xA4, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "H"));
		_database.add(new InstructionTemplate(0xA5, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "L"));
		_database.add(new InstructionTemplate(0xA6, "AND", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "(HL)"));
		_database.add(new InstructionTemplate(0xA7, "AND", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "A"));
		_database.add(new InstructionTemplate(0xA8, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "B"));
		_database.add(new InstructionTemplate(0xA9, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "C"));
		_database.add(new InstructionTemplate(0xAA, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "D"));
		_database.add(new InstructionTemplate(0xAB, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "E"));
		_database.add(new InstructionTemplate(0xAC, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "H"));
		_database.add(new InstructionTemplate(0xAD, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "L"));
		_database.add(new InstructionTemplate(0xAE, "XOR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "(HL)"));
		_database.add(new InstructionTemplate(0xAF, "XOR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "A"));
		_database.add(new InstructionTemplate(0xB0, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "B"));
		_database.add(new InstructionTemplate(0xB1, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "C"));
		_database.add(new InstructionTemplate(0xB2, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "D"));
		_database.add(new InstructionTemplate(0xB3, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "E"));
		_database.add(new InstructionTemplate(0xB4, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "H"));
		_database.add(new InstructionTemplate(0xB5, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "L"));
		_database.add(new InstructionTemplate(0xB6, "OR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "(HL)"));
		_database.add(new InstructionTemplate(0xB7, "OR", 4, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "A"));
		_database.add(new InstructionTemplate(0xB8, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xB9, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xBA, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xBB, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xBC, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xBD, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xBE, "CP", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xBF, "CP", 4, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xC0, "RET", 20/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NZ"));
		_database.add(new InstructionTemplate(0xC1, "POP", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "BC"));
		_database.add(new InstructionTemplate(0xC2, "JP", 16/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NZ,a16"));
		_database.add(new InstructionTemplate(0xC3, "JP", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "a16"));
		_database.add(new InstructionTemplate(0xC4, "CALL", 24/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NZ,a16"));
		_database.add(new InstructionTemplate(0xC5, "PUSH", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "BC"));
		_database.add(new InstructionTemplate(0xC6, "ADD", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,d8"));
		_database.add(new InstructionTemplate(0xC7, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "00H"));
		_database.add(new InstructionTemplate(0xC8, "RET", 20/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "Z"));
		_database.add(new InstructionTemplate(0xC9, "RET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		_database.add(new InstructionTemplate(0xCA, "JP", 16/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "Z,a16"));
//		_database.add(new InstructionTemplate(0xCB, "PREFIX", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "CB"));
		_database.add(new InstructionTemplate(0xCC, "CALL", 24/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "Z,a16"));
		_database.add(new InstructionTemplate(0xCD, "CALL", 24, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "a16"));
		_database.add(new InstructionTemplate(0xCE, "ADC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,d8"));
		_database.add(new InstructionTemplate(0xCF, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "08H"));
		_database.add(new InstructionTemplate(0xD0, "RET", 20/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NC"));
		_database.add(new InstructionTemplate(0xD1, "POP", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "DE"));
		_database.add(new InstructionTemplate(0xD2, "JP", 16/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NC,a16"));
		//0xD3 - Illegal Instruction
		_database.add(new InstructionTemplate(0xD4, "CALL", 24/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "NC,a16"));
		_database.add(new InstructionTemplate(0xD5, "PUSH", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "DE"));
		_database.add(new InstructionTemplate(0xD6, "SUB", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "d8"));
		_database.add(new InstructionTemplate(0xD7, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "10H"));
		_database.add(new InstructionTemplate(0xD8, "RET", 20/8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C"));
		_database.add(new InstructionTemplate(0xD9, "RETI", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		_database.add(new InstructionTemplate(0xDA, "JP", 16/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,a16"));
		//0xDB - Illegal Instruction
		_database.add(new InstructionTemplate(0xDC, "CALL", 24/12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "C,a16"));
		//0xDD - Illegal Instruction
		_database.add(new InstructionTemplate(0xDE, "SBC", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "A,d8"));
		_database.add(new InstructionTemplate(0xDF, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "18H"));
		_database.add(new InstructionTemplate(0xE0, "LDH", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(a8),A"));
		_database.add(new InstructionTemplate(0xE1, "POP", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "HL"));
		_database.add(new InstructionTemplate(0xE2, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(C),A"));
		//0xE3 - Illegal Instruction
		//0xE4 - Illegal Instruction
		_database.add(new InstructionTemplate(0xE5, "PUSH", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "HL"));
		_database.add(new InstructionTemplate(0xE6, "AND", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.OFF, "d8"));
		_database.add(new InstructionTemplate(0xE7, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "20H"));
		_database.add(new InstructionTemplate(0xE8, "ADD", 16, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "SP,r8"));
		_database.add(new InstructionTemplate(0xE9, "JP", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(HL)"));
		_database.add(new InstructionTemplate(0xEA, "LD", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "(a16),A"));
		//0xEB - Illegal Instruction
		//0xEC - Illegal Instruction
		//0xED - Illegal Instruction
		_database.add(new InstructionTemplate(0xEE, "XOR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "d8"));
		_database.add(new InstructionTemplate(0xEF, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "28H"));
		_database.add(new InstructionTemplate(0xF0, "LDH", 12, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(a8)"));
		_database.add(new InstructionTemplate(0xF1, "POP", 12, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "AF"));
		_database.add(new InstructionTemplate(0xF2, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(C)"));
		_database.add(new InstructionTemplate(0xF3, "DI", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		//0xF4 - Illegal Instruction
		_database.add(new InstructionTemplate(0xF5, "PUSH", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "AF"));
		_database.add(new InstructionTemplate(0xF6, "OR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "d8"));
		_database.add(new InstructionTemplate(0xF7, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "30H"));
		_database.add(new InstructionTemplate(0xF8, "LD", 12, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "HL,SP+r8"));
		_database.add(new InstructionTemplate(0xF9, "LD", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "SP,HL"));
		_database.add(new InstructionTemplate(0xFA, "LD", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "A,(a16)"));
		_database.add(new InstructionTemplate(0xFB, "EI", 4, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, ""));
		//0xFC - Illegal Instruction
		//0xFD - Illegal Instruction
		_database.add(new InstructionTemplate(0xFE, "CP", 8, FlagInfluance.COMPUTE, FlagInfluance.ON, FlagInfluance.COMPUTE, FlagInfluance.COMPUTE, "d8"));
		_database.add(new InstructionTemplate(0xFF, "RST", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "38H"));
		_database.add(new InstructionTemplate(0xCB00, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB01, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB02, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB03, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB04, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB05, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB06, "RLC", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB07, "RLC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB08, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB09, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB0A, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB0B, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB0C, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB0D, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB0E, "RRC", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB0F, "RRC", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB10, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB11, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB12, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB13, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB14, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB15, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB16, "RL", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB17, "RL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB18, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB19, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB1A, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB1B, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB1C, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB1D, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB1E, "RR", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB1F, "RR", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB20, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB21, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB22, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB23, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB24, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB25, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB26, "SLA", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB27, "SLA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB28, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "B"));
		_database.add(new InstructionTemplate(0xCB29, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "C"));
		_database.add(new InstructionTemplate(0xCB2A, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "D"));
		_database.add(new InstructionTemplate(0xCB2B, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "E"));
		_database.add(new InstructionTemplate(0xCB2C, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "H"));
		_database.add(new InstructionTemplate(0xCB2D, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "L"));
		_database.add(new InstructionTemplate(0xCB2E, "SRA", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "(HL)"));
		_database.add(new InstructionTemplate(0xCB2F, "SRA", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "A"));
		_database.add(new InstructionTemplate(0xCB30, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "B"));
		_database.add(new InstructionTemplate(0xCB31, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "C"));
		_database.add(new InstructionTemplate(0xCB32, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "D"));
		_database.add(new InstructionTemplate(0xCB33, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "E"));
		_database.add(new InstructionTemplate(0xCB34, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "H"));
		_database.add(new InstructionTemplate(0xCB35, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "L"));
		_database.add(new InstructionTemplate(0xCB36, "SWAP", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "(HL)"));
		_database.add(new InstructionTemplate(0xCB37, "SWAP", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.OFF, "A"));
		_database.add(new InstructionTemplate(0xCB38, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "B"));
		_database.add(new InstructionTemplate(0xCB39, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "C"));
		_database.add(new InstructionTemplate(0xCB3A, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "D"));
		_database.add(new InstructionTemplate(0xCB3B, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "E"));
		_database.add(new InstructionTemplate(0xCB3C, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "H"));
		_database.add(new InstructionTemplate(0xCB3D, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "L"));
		_database.add(new InstructionTemplate(0xCB3E, "SRL", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "(HL)"));
		_database.add(new InstructionTemplate(0xCB3F, "SRL", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.OFF, FlagInfluance.COMPUTE, "A"));
		_database.add(new InstructionTemplate(0xCB40, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,B"));
		_database.add(new InstructionTemplate(0xCB41, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,C"));
		_database.add(new InstructionTemplate(0xCB42, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,D"));
		_database.add(new InstructionTemplate(0xCB43, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,E"));
		_database.add(new InstructionTemplate(0xCB44, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,H"));
		_database.add(new InstructionTemplate(0xCB45, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,L"));
		_database.add(new InstructionTemplate(0xCB46, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,(HL)"));
		_database.add(new InstructionTemplate(0xCB47, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "0,A"));
		_database.add(new InstructionTemplate(0xCB48, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,B"));
		_database.add(new InstructionTemplate(0xCB49, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,C"));
		_database.add(new InstructionTemplate(0xCB4A, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,D"));
		_database.add(new InstructionTemplate(0xCB4B, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,E"));
		_database.add(new InstructionTemplate(0xCB4C, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,H"));
		_database.add(new InstructionTemplate(0xCB4D, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,L"));
		_database.add(new InstructionTemplate(0xCB4E, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,(HL)"));
		_database.add(new InstructionTemplate(0xCB4F, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "1,A"));
		_database.add(new InstructionTemplate(0xCB50, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,B"));
		_database.add(new InstructionTemplate(0xCB51, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,C"));
		_database.add(new InstructionTemplate(0xCB52, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,D"));
		_database.add(new InstructionTemplate(0xCB53, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,E"));
		_database.add(new InstructionTemplate(0xCB54, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,H"));
		_database.add(new InstructionTemplate(0xCB55, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,L"));
		_database.add(new InstructionTemplate(0xCB56, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,(HL)"));
		_database.add(new InstructionTemplate(0xCB57, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "2,A"));
		_database.add(new InstructionTemplate(0xCB58, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,B"));
		_database.add(new InstructionTemplate(0xCB59, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,C"));
		_database.add(new InstructionTemplate(0xCB5A, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,D"));
		_database.add(new InstructionTemplate(0xCB5B, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,E"));
		_database.add(new InstructionTemplate(0xCB5C, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,H"));
		_database.add(new InstructionTemplate(0xCB5D, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,L"));
		_database.add(new InstructionTemplate(0xCB5E, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,(HL)"));
		_database.add(new InstructionTemplate(0xCB5F, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "3,A"));
		_database.add(new InstructionTemplate(0xCB60, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,B"));
		_database.add(new InstructionTemplate(0xCB61, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,C"));
		_database.add(new InstructionTemplate(0xCB62, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,D"));
		_database.add(new InstructionTemplate(0xCB63, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,E"));
		_database.add(new InstructionTemplate(0xCB64, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,H"));
		_database.add(new InstructionTemplate(0xCB65, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,L"));
		_database.add(new InstructionTemplate(0xCB66, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,(HL)"));
		_database.add(new InstructionTemplate(0xCB67, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "4,A"));
		_database.add(new InstructionTemplate(0xCB68, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,B"));
		_database.add(new InstructionTemplate(0xCB69, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,C"));
		_database.add(new InstructionTemplate(0xCB6A, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,D"));
		_database.add(new InstructionTemplate(0xCB6B, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,E"));
		_database.add(new InstructionTemplate(0xCB6C, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,H"));
		_database.add(new InstructionTemplate(0xCB6D, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,L"));
		_database.add(new InstructionTemplate(0xCB6E, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,(HL)"));
		_database.add(new InstructionTemplate(0xCB6F, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "5,A"));
		_database.add(new InstructionTemplate(0xCB70, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,B"));
		_database.add(new InstructionTemplate(0xCB71, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,C"));
		_database.add(new InstructionTemplate(0xCB72, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,D"));
		_database.add(new InstructionTemplate(0xCB73, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,E"));
		_database.add(new InstructionTemplate(0xCB74, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,H"));
		_database.add(new InstructionTemplate(0xCB75, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,L"));
		_database.add(new InstructionTemplate(0xCB76, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,(HL)"));
		_database.add(new InstructionTemplate(0xCB77, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "6,A"));
		_database.add(new InstructionTemplate(0xCB78, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,B"));
		_database.add(new InstructionTemplate(0xCB79, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,C"));
		_database.add(new InstructionTemplate(0xCB7A, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,D"));
		_database.add(new InstructionTemplate(0xCB7B, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,E"));
		_database.add(new InstructionTemplate(0xCB7C, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,H"));
		_database.add(new InstructionTemplate(0xCB7D, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,L"));
		_database.add(new InstructionTemplate(0xCB7E, "BIT", 16, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,(HL)"));
		_database.add(new InstructionTemplate(0xCB7F, "BIT", 8, FlagInfluance.COMPUTE, FlagInfluance.OFF, FlagInfluance.ON, FlagInfluance.NONE, "7,A"));
		_database.add(new InstructionTemplate(0xCB80, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,B"));
		_database.add(new InstructionTemplate(0xCB81, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,C"));
		_database.add(new InstructionTemplate(0xCB82, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,D"));
		_database.add(new InstructionTemplate(0xCB83, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,E"));
		_database.add(new InstructionTemplate(0xCB84, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,H"));
		_database.add(new InstructionTemplate(0xCB85, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,L"));
		_database.add(new InstructionTemplate(0xCB86, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,(HL)"));
		_database.add(new InstructionTemplate(0xCB87, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,A"));
		_database.add(new InstructionTemplate(0xCB88, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,B"));
		_database.add(new InstructionTemplate(0xCB89, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,C"));
		_database.add(new InstructionTemplate(0xCB8A, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,D"));
		_database.add(new InstructionTemplate(0xCB8B, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,E"));
		_database.add(new InstructionTemplate(0xCB8C, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,H"));
		_database.add(new InstructionTemplate(0xCB8D, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,L"));
		_database.add(new InstructionTemplate(0xCB8E, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,(HL)"));
		_database.add(new InstructionTemplate(0xCB8F, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,A"));
		_database.add(new InstructionTemplate(0xCB90, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,B"));
		_database.add(new InstructionTemplate(0xCB91, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,C"));
		_database.add(new InstructionTemplate(0xCB92, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,D"));
		_database.add(new InstructionTemplate(0xCB93, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,E"));
		_database.add(new InstructionTemplate(0xCB94, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,H"));
		_database.add(new InstructionTemplate(0xCB95, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,L"));
		_database.add(new InstructionTemplate(0xCB96, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,(HL)"));
		_database.add(new InstructionTemplate(0xCB97, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,A"));
		_database.add(new InstructionTemplate(0xCB98, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,B"));
		_database.add(new InstructionTemplate(0xCB99, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,C"));
		_database.add(new InstructionTemplate(0xCB9A, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,D"));
		_database.add(new InstructionTemplate(0xCB9B, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,E"));
		_database.add(new InstructionTemplate(0xCB9C, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,H"));
		_database.add(new InstructionTemplate(0xCB9D, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,L"));
		_database.add(new InstructionTemplate(0xCB9E, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,(HL)"));
		_database.add(new InstructionTemplate(0xCB9F, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,A"));
		_database.add(new InstructionTemplate(0xCBA0, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,B"));
		_database.add(new InstructionTemplate(0xCBA1, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,C"));
		_database.add(new InstructionTemplate(0xCBA2, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,D"));
		_database.add(new InstructionTemplate(0xCBA3, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,E"));
		_database.add(new InstructionTemplate(0xCBA4, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,H"));
		_database.add(new InstructionTemplate(0xCBA5, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,L"));
		_database.add(new InstructionTemplate(0xCBA6, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,(HL)"));
		_database.add(new InstructionTemplate(0xCBA7, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,A"));
		_database.add(new InstructionTemplate(0xCBA8, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,B"));
		_database.add(new InstructionTemplate(0xCBA9, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,C"));
		_database.add(new InstructionTemplate(0xCBAA, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,D"));
		_database.add(new InstructionTemplate(0xCBAB, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,E"));
		_database.add(new InstructionTemplate(0xCBAC, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,H"));
		_database.add(new InstructionTemplate(0xCBAD, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,L"));
		_database.add(new InstructionTemplate(0xCBAE, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,(HL)"));
		_database.add(new InstructionTemplate(0xCBAF, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,A"));
		_database.add(new InstructionTemplate(0xCBB0, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,B"));
		_database.add(new InstructionTemplate(0xCBB1, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,C"));
		_database.add(new InstructionTemplate(0xCBB2, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,D"));
		_database.add(new InstructionTemplate(0xCBB3, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,E"));
		_database.add(new InstructionTemplate(0xCBB4, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,H"));
		_database.add(new InstructionTemplate(0xCBB5, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,L"));
		_database.add(new InstructionTemplate(0xCBB6, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,(HL)"));
		_database.add(new InstructionTemplate(0xCBB7, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,A"));
		_database.add(new InstructionTemplate(0xCBB8, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,B"));
		_database.add(new InstructionTemplate(0xCBB9, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,C"));
		_database.add(new InstructionTemplate(0xCBBA, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,D"));
		_database.add(new InstructionTemplate(0xCBBB, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,E"));
		_database.add(new InstructionTemplate(0xCBBC, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,H"));
		_database.add(new InstructionTemplate(0xCBBD, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,L"));
		_database.add(new InstructionTemplate(0xCBBE, "RES", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,(HL)"));
		_database.add(new InstructionTemplate(0xCBBF, "RES", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,A"));
		_database.add(new InstructionTemplate(0xCBC0, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,B"));
		_database.add(new InstructionTemplate(0xCBC1, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,C"));
		_database.add(new InstructionTemplate(0xCBC2, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,D"));
		_database.add(new InstructionTemplate(0xCBC3, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,E"));
		_database.add(new InstructionTemplate(0xCBC4, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,H"));
		_database.add(new InstructionTemplate(0xCBC5, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,L"));
		_database.add(new InstructionTemplate(0xCBC6, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,(HL)"));
		_database.add(new InstructionTemplate(0xCBC7, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "0,A"));
		_database.add(new InstructionTemplate(0xCBC8, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,B"));
		_database.add(new InstructionTemplate(0xCBC9, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,C"));
		_database.add(new InstructionTemplate(0xCBCA, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,D"));
		_database.add(new InstructionTemplate(0xCBCB, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,E"));
		_database.add(new InstructionTemplate(0xCBCC, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,H"));
		_database.add(new InstructionTemplate(0xCBCD, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,L"));
		_database.add(new InstructionTemplate(0xCBCE, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,(HL)"));
		_database.add(new InstructionTemplate(0xCBCF, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "1,A"));
		_database.add(new InstructionTemplate(0xCBD0, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,B"));
		_database.add(new InstructionTemplate(0xCBD1, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,C"));
		_database.add(new InstructionTemplate(0xCBD2, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,D"));
		_database.add(new InstructionTemplate(0xCBD3, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,E"));
		_database.add(new InstructionTemplate(0xCBD4, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,H"));
		_database.add(new InstructionTemplate(0xCBD5, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,L"));
		_database.add(new InstructionTemplate(0xCBD6, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,(HL)"));
		_database.add(new InstructionTemplate(0xCBD7, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "2,A"));
		_database.add(new InstructionTemplate(0xCBD8, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,B"));
		_database.add(new InstructionTemplate(0xCBD9, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,C"));
		_database.add(new InstructionTemplate(0xCBDA, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,D"));
		_database.add(new InstructionTemplate(0xCBDB, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,E"));
		_database.add(new InstructionTemplate(0xCBDC, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,H"));
		_database.add(new InstructionTemplate(0xCBDD, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,L"));
		_database.add(new InstructionTemplate(0xCBDE, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,(HL)"));
		_database.add(new InstructionTemplate(0xCBDF, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "3,A"));
		_database.add(new InstructionTemplate(0xCBE0, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,B"));
		_database.add(new InstructionTemplate(0xCBE1, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,C"));
		_database.add(new InstructionTemplate(0xCBE2, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,D"));
		_database.add(new InstructionTemplate(0xCBE3, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,E"));
		_database.add(new InstructionTemplate(0xCBE4, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,H"));
		_database.add(new InstructionTemplate(0xCBE5, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,L"));
		_database.add(new InstructionTemplate(0xCBE6, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,(HL)"));
		_database.add(new InstructionTemplate(0xCBE7, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "4,A"));
		_database.add(new InstructionTemplate(0xCBE8, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,B"));
		_database.add(new InstructionTemplate(0xCBE9, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,C"));
		_database.add(new InstructionTemplate(0xCBEA, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,D"));
		_database.add(new InstructionTemplate(0xCBEB, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,E"));
		_database.add(new InstructionTemplate(0xCBEC, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,H"));
		_database.add(new InstructionTemplate(0xCBED, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,L"));
		_database.add(new InstructionTemplate(0xCBEE, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,(HL)"));
		_database.add(new InstructionTemplate(0xCBEF, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "5,A"));
		_database.add(new InstructionTemplate(0xCBF0, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,B"));
		_database.add(new InstructionTemplate(0xCBF1, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,C"));
		_database.add(new InstructionTemplate(0xCBF2, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,D"));
		_database.add(new InstructionTemplate(0xCBF3, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,E"));
		_database.add(new InstructionTemplate(0xCBF4, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,H"));
		_database.add(new InstructionTemplate(0xCBF5, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,L"));
		_database.add(new InstructionTemplate(0xCBF6, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,(HL)"));
		_database.add(new InstructionTemplate(0xCBF7, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "6,A"));
		_database.add(new InstructionTemplate(0xCBF8, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,B"));
		_database.add(new InstructionTemplate(0xCBF9, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,C"));
		_database.add(new InstructionTemplate(0xCBFA, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,D"));
		_database.add(new InstructionTemplate(0xCBFB, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,E"));
		_database.add(new InstructionTemplate(0xCBFC, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,H"));
		_database.add(new InstructionTemplate(0xCBFD, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,L"));
		_database.add(new InstructionTemplate(0xCBFE, "SET", 16, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,(HL)"));
		_database.add(new InstructionTemplate(0xCBFF, "SET", 8, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, FlagInfluance.NONE, "7,A"));
	}

	public static InstructionTemplate match(final CommandTokens tokens)
	{
		InstructionTemplate bestMatch = null;

		for(final InstructionTemplate instructionTemplate : _database)
		{
			if(instructionTemplate.matches(tokens))
			{
				if(bestMatch == null || instructionTemplate.betterThan(bestMatch))
				{
					bestMatch = instructionTemplate;
				}
			}
		}

		return bestMatch;
	}

	public static boolean isCommandRecognized(final String commandName)
	{
		for(final InstructionTemplate instructionTemplate : _database)
		{
			if(instructionTemplate.getCommand().equalsIgnoreCase(commandName))
			{
				return true;
			}
		}

		return false;
	}

	public static int getFirstUnrecognizedParameterIndex(final CommandTokens tokens)
	{
		int i = 0;

		for(final InstructionTemplate instructionTemplate : _database)
		{
			if(instructionTemplate.getCommand().equalsIgnoreCase(tokens.getCommand()))
			{
				for(int j = 0; j < instructionTemplate.getParametersCount(); j++)
				{
					final InstructionParameter parameter = instructionTemplate.getParameter(j);
					if(parameter.matches(tokens.getArgument(j)))
					{
						i = Integer.max(i, j + 1);
					}
					else
					{
						break;
					}
				}
			}
		}

		return i;
	}
}
