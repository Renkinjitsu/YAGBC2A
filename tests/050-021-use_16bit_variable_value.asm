define string __program_name "16bit test"
define string __manufacturer_code "---"
define word six-thousand 1770H; 6000 = 0x7017 (little endian)

main:
	LD BC, *six-thousand	;0x017017 = 0x01 | *six-thousand
