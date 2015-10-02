# Status memo

This document is a memo that describes the deficiencies in the project in comparison with the language manual. It contains the parts of the language manual that are either not yet supported or implemented in an mismatching way.

## Syntax

#### Storage types

The following types are not yet supported:

- `byte` - An 8-bit number
- `word` - A 16-bit number

##### String type

A string value may contain only the following characters:

- a-z
- A-Z
- 0-9
- !@#$%^&*()_+-=\/?|.,><:'"[]{}

The above is not verified

###### Special characters

Escaping are not implemented

#### Variable name

Missing verification that a name of a variable is not a number and does not contain a white-space(s).

#### Local variable

Not yet supported.

#### Variable's value-usage vs. location-usage

Not yet supported.
