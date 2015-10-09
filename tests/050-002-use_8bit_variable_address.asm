define string __program_name "8bit test"
define string __manufacturer_code "---"
define byte twelve 000CH; 12 = 0x0C

main:
	LD A, &twelve ;0xFA???? = 0xFA | &twelve
