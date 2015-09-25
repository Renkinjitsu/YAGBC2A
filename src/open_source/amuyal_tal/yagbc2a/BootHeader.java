package open_source.amuyal_tal.yagbc2a;

import java.util.ArrayList;
import java.util.List;

import open_source.amuyal_tal.yagbc2a.cartridege.InterruptHandler;
import open_source.amuyal_tal.yagbc2a.cartridege.Linker;
import open_source.amuyal_tal.yagbc2a.cartridege.MemorySection;
import open_source.amuyal_tal.yagbc2a.cartridege.ResetHandler;
import open_source.amuyal_tal.yagbc2a.cartridege.Linker.KnownSymbols;
import open_source.amuyal_tal.yagbc2a.instruction.InstructionTemplate;
import open_source.amuyal_tal.yagbc2a.utils.Utils;
import open_source.amuyal_tal.yagbc2a.utils.adt.BytesArray;
import open_source.amuyal_tal.yagbc2a.utils.adt.MutableBytesArray;

public final class BootHeader
{
	private static final int resetHandlersCount = 8; //H/W configuration
	private static final int interruptHandlersCount = 5; //H/W configuration

	private static final String[] interruptNames = {"draw", "stat", "timer", "serial", "joypad"};

	private static final byte NO_OPERATION = (byte)0x00;

	public static byte calculateHeaderChecksum(
			final BytesArray headerData
			)
	{
		byte checksum = 0;

		for(int i = 0x134; i <= 0x14C; i++)
		{
			checksum = (byte)(checksum - headerData.getAt(i) - 1);
		}

		return checksum;
	}

	public static int getSize()
	{
		return 0x150;
	}

	private final ResetHandler[] _resetHandler;
	private final InterruptHandler[] _interruptHandler;
	private final MemorySection _ram0; //General purpose 152 bytes of RAM
	private final MemorySection _romStartupHandler; //4 bytes of ROM that are executed after the boot verification
	private final MemorySection _romNintendoLogo;
	private final MemorySection _romTitle; //11 bytes of ROM that are the name of the program
	private final MemorySection _romManufacturerCode; //4 bytes of "manufacturer code"; default is an empty string
	private final MemorySection _romGameboyColorCompatibilityFlag; //1 byte ROM of "Gameboy Color compatibility" flag
	private final MemorySection _romLicenseCode; //2 bytes ROM of "license code"
	private final MemorySection _romSuperGameboyCompatibilityFlag; //1 byte ROM of "Super Gameboy compatibility" flag
	private final MemorySection _romCartridgeType; //1 byte ROM of "cartridge type" flag
	private final MemorySection _romRomSize; //1 byte ROM of "ROM size"
	private final MemorySection _romRamSize; //1 byte ROM of "RAM size"
	private final MemorySection _romDestinationCode; //1 byte ROM of "destination code"
	private final MemorySection _romOldLicenseeCode; //1 byte ROM of "old licensee code"
	private final MemorySection _romVersionNumber; //1 byte ROM of "Mask ROM Version number"
	private final MemorySection _romHeaderChecksum; //1 byte ROM of "header checksum"
	private final MemorySection _romGlobalChecksum; //2 byte ROM of "global checksum"

	private final List<MemorySection> _memorySections;

	public BootHeader()
	{
		_memorySections = new ArrayList<MemorySection>();

		_resetHandler = new ResetHandler[resetHandlersCount];
		for(int i = 0; i < _resetHandler.length; i++)
		{
			_resetHandler[i] = new ResetHandler();
			_memorySections.add(_resetHandler[i]);
		}

		_interruptHandler = new InterruptHandler[interruptHandlersCount];
		for(int i = 0; i < interruptHandlersCount; i++)
		{
			_interruptHandler[i] = new InterruptHandler(interruptNames[i]);
			_memorySections.add(_interruptHandler[i]);
		}

		_ram0 = new MemorySection(
				"General purpose R-W",
				152,
				NO_OPERATION);

		_romStartupHandler = new MemorySection("Execution start", 4, NO_OPERATION);

		_romNintendoLogo = new MemorySection("Nintendo logo", 48);
		setNintendoLogo();

		_romTitle = new MemorySection("Program title", 11, (byte)0); //Set null-termination and pad if needed

		_romManufacturerCode = new MemorySection("Manufacturer code", 4, (byte)0); //Set null-termination and pad if needed

		//0x00 - Unsupported
		//0x80 - Compatible
		//0xC0 - Exclusive
		_romGameboyColorCompatibilityFlag = new MemorySection("Gameboy color compatibility flag", 1, (byte)0x00); //TODO: Support other options

		_romLicenseCode = new MemorySection("License code", 2, (byte)'-'); //TODO: Support choosing the license code

		//0x00 - Unsupported
		//0x03 - Supported
		_romSuperGameboyCompatibilityFlag = new MemorySection("Super GameBoy compatibility flag", 1, (byte)0x00); //TODO: Support other options

		//0x00 - "regular"
		_romCartridgeType = new MemorySection("Cartridge type", 1, (byte)0x00); //TODO: Support other options

		//0x00 - ROM_32K
		//0x01 - ROM_64K
		//0x02 - ROM_128K
		//0x03 - ROM_256K
		//0x04 - ROM_512K
		//0x05 - ROM_1024K
		//0x06 - ROM_2048K
		//0x07 - ROM_4096K
		//0x52 - ROM_1152K
		//0x53 - ROM_1280K
		//0x54 - ROM_1536K
		_romRomSize = new MemorySection("ROM size", 1, (byte)0x00);

		//0x00 - RAM_NONE
		//0x01 - RAM_2K
		//0x02 - RAM_8K
		//0x03 - RAM_32K
		_romRamSize = new MemorySection("RAM size", 1, (byte)0x00);

		//0x00 - DEST_JAPAN
		//0x01 - DEST_INTERNATIONAL
		_romDestinationCode = new MemorySection("Destination code", 1, (byte)0x01);

		//0x33 indicates new license code will be used - it must be used for SGB games
		_romOldLicenseeCode = new MemorySection("Old license code", 1, (byte)0x33);

		_romVersionNumber = new MemorySection("Version number", 1, (byte)0x00);

		_romHeaderChecksum = new MemorySection("Header checksum", 1); //Calculated at a later stage

		//Not calculated as the Gameboy doesn't verify that
		_romGlobalChecksum = new MemorySection("Global checksum", 2, (byte)0x00);

		_memorySections.add(_ram0);
		_memorySections.add(_romStartupHandler);
		_memorySections.add(_romNintendoLogo);
		_memorySections.add(_romTitle);
		_memorySections.add(_romManufacturerCode);
		_memorySections.add(_romGameboyColorCompatibilityFlag);
		_memorySections.add(_romLicenseCode);
		_memorySections.add(_romSuperGameboyCompatibilityFlag);
		_memorySections.add(_romCartridgeType);
		_memorySections.add(_romRomSize);
		_memorySections.add(_romRamSize);
		_memorySections.add(_romDestinationCode);
		_memorySections.add(_romOldLicenseeCode);
		_memorySections.add(_romVersionNumber);
		_memorySections.add(_romHeaderChecksum);
		_memorySections.add(_romGlobalChecksum);
	}

	public BytesArray assemble(
			final int codeStartAddress,
			final String programName,
			final String manufacturerCode
			)
	{
		setCodeStartAddress(codeStartAddress);
		setProgramName(programName);
		setManufacturerCode(manufacturerCode);

		final BytesArray assembled = new MutableBytesArray();

		for(final MemorySection memorySection : _memorySections)
		{
			assembled.append(memorySection.getData());
		}

		final byte headerChecksum = BootHeader.calculateHeaderChecksum(assembled);
		assembled.setAt(0x14D, headerChecksum);

		return assembled;
	}

	private void setCodeStartAddress(final int codeStartAddress)
	{
		final String jumpMainAssemblyCode = String.format(
				"JP %d",
				codeStartAddress
				);

		try
		{
			final CommandTokens jumpMainCommandTokens = new CommandTokens(jumpMainAssemblyCode);

			final InstructionTemplate jumpMainInstructionTemplate = InstructionDataBase.match(jumpMainCommandTokens);
			final BytesArray jumpMainMachineCode = jumpMainInstructionTemplate.assemble(jumpMainCommandTokens);

			//Preceding space if filled with NOPs
			final int paddedSpaceSize = _romStartupHandler.getSize() - jumpMainMachineCode.getSize();
			for(int i = 0; i < jumpMainMachineCode.getSize(); i++)
			{
				_romStartupHandler.setByte(paddedSpaceSize + i, jumpMainMachineCode.getAt(i));
			}
		}
		catch(final SyntaxException ex)
		{
			Utils.abort(ex);
		}
	}

	private void setNintendoLogo()
	{
		final int[] nintendoLogoArray = //Nintendo logo
			{
				0xCE, 0xED, 0x66, 0x66, 0xCC, 0x0D, 0x00, 0x0B,
				0x03, 0x73, 0x00, 0x83, 0x00, 0x0C, 0x00, 0x0D,
				0x00, 0x08, 0x11, 0x1F, 0x88, 0x89, 0x00, 0x0E,
				0xDC, 0xCC, 0x6E, 0xE6, 0xDD, 0xDD, 0xD9, 0x99,
				0xBB, 0xBB, 0x67, 0x63, 0x6E, 0x0E, 0xEC, 0xCC,
				0xDD, 0xDC, 0x99, 0x9F, 0xBB, 0xB9, 0x33, 0x3E
			};

		for(int i = 0; i < nintendoLogoArray.length; i++)
		{
			_romNintendoLogo.setByte(i, (byte)(nintendoLogoArray[i]));
		}
	}

	private void setProgramName(final String programName)
	{
		if(programName.length() > 10)
		{
			final String error = String.format(
					"The value of symbol `%s` may not exceed 10 bytes",
					Linker.KnownSymbols.PROGRAM_NAME
					);
			Utils.abort(error);
		}

		for(int i = 0; i < programName.length(); i++)
		{
			_romTitle.setByte(i, (byte)programName.charAt(i));
		}
	}

	private void setManufacturerCode(final String manufacturerCode)
	{
		if(manufacturerCode.length() > 3)
		{
			final String error = String.format(
					"The value of symbol `%s` may not exceed 3 bytes",
					KnownSymbols.MANUFACTURER_CODE
					);
			Utils.abort(error);
		}

		for(int i = 0; i < manufacturerCode.length(); i++)
		{
			_romManufacturerCode.setByte(i, (byte)manufacturerCode.charAt(i));
		}
	}
}
