/**
 * Project has started at 7/8/2015
 */
package open_source.amuyal_tal.yagbc2a;

import java.io.IOException;

import open_source.amuyal_tal.yagbc2a.cartridege.Linker;
import open_source.amuyal_tal.yagbc2a.utils.Utils;

/**
 *
 */
public final class Main
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("YAGBC2A  Copyright (C) 2015  Tal Amuyal");
			System.exit(0);
		}

		try
		{
			String destFilePath = "a.gb";

			//Verify parameters

			if(args.length < 1)
			{
				System.out.println("No source file is provided");
				throw new HandledException();
			}

			final String sourceFilePath = args[0];

			for(int i = 1; i < args.length; i++)
			{
				switch(args[i])
				{
					case "--version":
					case "-v":
					{
						System.out.println("YAGBC2A - Version 0.1");
						throw new HandledException();
					}

					case "--output":
					case "-o":
					{
						i++;
						if(i < args.length)
						{
							destFilePath = args[i];
						}
						else
						{
							System.out.println("Missing output file name");
							throw new HandledException();
						}
					}
					break;

					default:
					{
						System.out.println("Unknown flag \'" + args[i] + "\'");
						throw new HandledException();
					}
				}
			}

			//TODO: Verify source-file path format
			//TODO: Verify source-file existence

			//TODO: Verify destination-file path format

			//TODO: Warn if destination-file exists (shall be overridden)
			//TODO: Check if existing file is up to date

			//End of parameters verification

			final SourceFile sourceFile = new SourceFile();
			sourceFile.readFile(sourceFilePath);

			final Linker linker = new Linker();

			linker.linkObject(Assembler.assemble(sourceFile));

			linker.emit(destFilePath);

			//TODO: Print statistics
		}
		catch(final HandledException ex)
		{
			//An error accrued and a proper message has been displayed
		}
		catch(final Throwable throwable)
		{
			Utils.displayError(throwable);
		}
	}
}
