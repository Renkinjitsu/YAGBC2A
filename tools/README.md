# Tester
`Tester` is a testing tool made to test the `YAGBCCA` project quickly and easily. It uses conventions in order of simplicity and easy of implementation and maintenance.

`Tester` compiles each `*.asm` file it finds in the configured directory and compares it (binary comparison) to a the matching output file (which is a file with the same name but a `.gb` extension).

Each test-case should be composed of at least two files: an assembly source-code file, and it's compiled version. The source-code's name should be as described below.

1. Source-code's name should match the following pattern: `[group ID]-[sub-group ID]-[test name].asm`.
1. `[group ID]` and `[sub-group ID]` are a three digit number (each).
1. `[test name]` is an underscored short description of the test.

The test-cases are divided to groups and  sub-groups by numbers for order of execution, as some tests depends on others to succeed.

Test-case name example: `010-010-compile_empty_executable.asm`.

The example test is a minimal test for the compiler capabilities that requires nothing except for simple file parsing and the proper generation of the boot-header.

# CompileAll

`CompileAll` is a tool that compiles all of a folders `*.asm` files using YAGBCCA.
It can be used either as a python module or as a command line application and arguments may be provided for non-default configurations.

For more information, refer to `CompileAll.py`-'s header.
