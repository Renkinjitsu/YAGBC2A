package open_source.amuyal_tal.yagbc2a.cartridege;


public class ResetHandler extends MemorySection
{
	private static final int segmentSize = 8; //H/W configuration (in bytes)

	public ResetHandler()
	{
		super("Reset handler", segmentSize, (byte)0x00); //`0x00` is `NOP`

		//Fill with default "empty" implementation
		super.setByte(0, (byte)0xC9); //`0xC9` is `return (void)`
	}
}
