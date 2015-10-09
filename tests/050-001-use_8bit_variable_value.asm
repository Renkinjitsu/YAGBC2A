define string __program_name "8bit test"
define string __manufacturer_code "---"
define byte twelve 000CH; 12 = 0x0C

main:
	LD L, *twelve ;0x2E0C = 0x2E | *twelve
