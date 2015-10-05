"""
@ Set-up instructions

In order to run this tool, the following steps are required:
1. Set the working directory to the project's root.
2. Build the project into a "bin" directory under the project's root.
3. JRE must be installed and available globally through OS shell.

The above may be altered by reconfiguring the proper variables or by
 providing arguments.


@ Arguments

* -s=<path> --source=<path>    The path of the assembly files directory
* -d=<path> --destination=<path>    The path for the assembled files directory
* -p=<path> --project=<path>    The path for the compiler directory

Note(s):
1. A directory's path should end with a trailing forword-slash (`/`).
2. In paths, spaces are not supported
"""


"""
Imports
"""
import os
import sys


"""
Functions
"""
def main(argv):
	"""
	Set configurations
	"""
	JAVA_INTERPRETER = "java"
	COMPILED_PROJECT_DIR = "bin"
	COMPILED_PROJECT = "open_source.amuyal_tal.yagbc2a.Main"
	INPUT_DIR = "tests"
	OUTPUT_DIR = "bin"


	"""
	Parse arguments-vector
	"""
	for arg in argv:
		splitArg = arg.split("=")

		if len(splitArg) != 2:
			sys.exit("Unregocnized command ", arg)

		key = splitArg[0]
		value = splitArg[1]

		if key == "-p" or key == "--project":
			COMPILED_PROJECT_DIR = value
		elif key == "-s" or key == "--source":
			INPUT_DIR = value
		elif key == "-d" or key == "--destination":
			OUTPUT_DIR = value
		else:
			sys.exit("Unregocnized command ", arg)


	"""
	Normalize configurations
	"""
	if not INPUT_DIR.endswith("/"):
		INPUT_DIR = INPUT_DIR + "/"

	if not OUTPUT_DIR.endswith("/"):
		OUTPUT_DIR = OUTPUT_DIR + "/"


	"""
	Compile
	"""
	for file in os.listdir(INPUT_DIR):
		if file.endswith(".asm"):
			commandArgs = [JAVA_INTERPRETER, "-cp", COMPILED_PROJECT_DIR, COMPILED_PROJECT, INPUT_DIR + file, "-o", OUTPUT_DIR + file[:-4] + ".gb"]
			compileCommand = " ".join(commandArgs)
			os.popen(compileCommand).read() #Executa command and hide output


"""
Main
"""
if __name__ == "__main__":
	main(sys.argv[1:])

