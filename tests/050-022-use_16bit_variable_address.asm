define string __program_name "16bit test"
define string __manufacturer_code "---"
define word six-thousand 1770H; 6000 = 0x7017 (little endian)

main:
	LD &six-thousand,SP	;0x08???? = 0x08 | &six-thousand
