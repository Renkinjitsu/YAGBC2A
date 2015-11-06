# Language manual

This document describes the assembly language supported by the YAGBCCA project.

## Syntax

### Directives

Each directive must be in it's own line, thus a directive may not be broken into lines, nor be composed of multiple lines.

### Comments

A comment begins in a semi-colon (`;`) and ends at the line's end.

### Variables

Variables are declared thus: `define [type] [name] [value]`

#### Storage types

The supported types are:

- `byte` - An 8-bit number
- `word` - A 16-bit number
- `string` - A sequence of null-terminated ANSI characters

##### Numerical types

A value of a number type should be written as a plain number. The default base is decimal. a specific base may be marked in the following ways:

- `0x` prefix - marks hexadecimal
- `0d` prefix - marks decimal
- `0b` prefix - marks binary
- `H` post-fix - marks hexadecimal
- `D` post-fix - marks decimal
- `B` post-fix - marks binary

No more then a single base-specifier is allowed.

##### String type

A string value may contain only the characters specified below and must be surrounded by quotation marks (`"`).

Allowed characters:
- a-z
- A-Z
- 0-9
- !@#$%^&*()_+-=\/?|.,><:'"[]{}

###### Special characters

Special characters are characters that has an added functionality. The special characters are the quotation mark (`"`) and backslash (`\`) characters. As such, a method of differentiation is required. The differentiation method is thus: the default meaning of a special character is it's non-character, added-functionality. in order to indicate the "regular" character functionality, Escaping should be performed. Escaping is done by adding a a single backslash (`\`) before the special character. An escaped special character is regarded together with the escaping character (the backslash (`'`) prefix) as a single character.

#### Variable name

The name of a variable must not be a number, must not contain a white-space(s), and must not contain a semi-colon (`;`).

#### Local variable

A local variable is a variable that is defined in a function's scope and allocated from the Run Time Stack and thus it is available only from within the containing function.

#### Global variable

A global variable is a variable that is defined outside of every function's scope and thus is available from every point in the program.

#### Variable's value-usage vs. location-usage

A variable has both a location (address) in the memory as well as a value. When a variable's name is used in the code, it's usage type must also be specified.

The usage of the location (address) or the value of a variable is specified by a prefix to the variable's name. For the location (address) of variable, the prefix if an ampersand (`&`) and for the value of a variable, the prefix is an asterisk (`*`).

Pseudo-code example:

    define byte variable 42 ; Define a variable of type `byte` that is called `variable` with a value of `42`
    Load register0, *variable ; Copy the value of variable (42) to register0
    Load register1, &variable ; Copy the location/memory-address of variable to register1

Note, that if the value of a variable is changed at run time, the consequence of a value-usage is undefined. Thus, it is recommended to use each variable with a single usage-specifier throughout the variable's life-time.

### Functions

A function shall begin in a deceleration line and end in a termination line. All of the code encapsulated in these lines are owned by the function and are local to it by default. The deceleration line is of the form `func [function name]` and the termination line is `end`.

    func exemple
    ;Code comes here
    end

### Labels

Labels are defined thus `[name]:`

Example:

    LD A, B
    again:
    INC B
    JP again

## Instructions

A full list of the processor's instructions can be found [here](http://www.pastraiser.com/cpu/gameboy/gameboy_opcodes.html).

## Relative instructions

Relative instructions (such as HDL and JR) are used in conjunction with absolute values and symbols. On compile-time, the offset is calculated using the provided absolute address.
