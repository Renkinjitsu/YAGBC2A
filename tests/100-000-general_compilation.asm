define string __program_name "Test1"
define string __manufacturer_code "---"
;define byte twelve 00000CH

main:
	LD B,B		;0x40
	CALL func1	;0xCD8001
	HALT		;0x76
	LD A,(C)	;0xF2
	LD HL,SP+17	;0xF811
	DI			;0xF3
	CALL NZ,299	;0xC42B01
	CALL NZ,29	;0xC41D00
	SET 0,(HL)	;0xCBC6
	RR D		;0xCB1A
	SLA B		;0xCB20
	RST 30H		;0xF7
	LDH (8),A	;0xE008
	POP BC		;0xC1
	XOR 12		;0xEE0C
	XOR 1CH		;0xEE1C
	LD (0xBE),SP		;0x08BE00
	LD (0b10101100),SP	;0x08AC00
	CALL Z,0d21987		;0xCCE355
	;LDH A,twelve

func func1
	XOR 1CH		;0xEE1C
	RET				;C9
end
