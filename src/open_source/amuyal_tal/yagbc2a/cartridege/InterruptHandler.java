package open_source.amuyal_tal.yagbc2a.cartridege;


public class InterruptHandler extends MemorySection
{
	private static final int segmentSize = 8; //H/W configuration (in bytes)

	public InterruptHandler(
			final String interruptName
			)
	{
		super(interruptName + " interrupt handler", segmentSize, (byte)0x00); //`0x00` is `NOP`

		//Fill with default "empty" implementation
		super.setByte(0, (byte)0xD9); //`0xD9` is `return-interrupt (void)`
	}
}
