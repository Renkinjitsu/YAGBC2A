"""
@ Set-up instructions

In order to run this tool, the following steps are required:
1. Set the working directory to the project's root.
2. Build the project into a "bin" directory under the project's root.
3. JRE must be installed and available globally through OS shell.

The above may be altered by reconfiguring the proper variables


@ Note(s)

- After each run, the compiled test files are kept for manual debugging and inspection, but deleted at the beginning of the next execution of this tool.
"""

"""
Configurations
"""
JAVA_DIR = ""
COMPILER_DIR = "bin"
TESTS_DIR = "tests"
TEST_TEMP_BIN_DIR = "bin"
TEST_EXPECTATION_DIR = "tests"

import os

"""
Clean previous temporary compilations
"""
for file in os.listdir(TEST_TEMP_BIN_DIR):
	if file.endswith(".elf"):
		os.remove(TEST_TEMP_BIN_DIR + "/" + file)

"""
Create errors container
"""
errors = []

"""
Execute test-suit
"""
for file in os.listdir(TESTS_DIR):
	if file.endswith(".asm"):
		print("For `" + file + "`: compiling...",end="",flush=True)
		fileName = file[:-4];
		os.system(JAVA_DIR + "java -cp " + COMPILER_DIR + " open_source.amuyal_tal.yagbc2a.Main " + TESTS_DIR + "/" + fileName + ".asm -o " + TEST_TEMP_BIN_DIR + "/" + fileName + ".elf")
		print(" testing...")
		if os.path.isfile(TEST_TEMP_BIN_DIR + "/" + fileName + ".elf"):
			with open(TEST_EXPECTATION_DIR + "/" + fileName + ".elf") as expected, open(TEST_TEMP_BIN_DIR + "/" + fileName + ".elf") as result:
				if expected.read() != result.read():
					errors.append("`" + file + "` produces unexpected results")
		else:
			errors.append(file + " couldn't be compiled")

"""
Print visual segmentation
"""
print()
print("=" * 10 + " Test-suit run complete " + "=" * 10)
print()

"""
Report result
"""
if len(errors) == 0:
	print("No errors detected")
else:
	print(str(len(errors)) + " errors detected:")
	print()
	index = 0
	for error in errors:
		index = index + 1
		print(str(index) + ") " + error)

