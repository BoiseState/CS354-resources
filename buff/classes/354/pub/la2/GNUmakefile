prog?=$(basename $(notdir $(PWD)))

$(prog): test.v [A-Z]*.v monitor
	iverilog -o $@ -s $@ $(filter %.v,$^) -g 2012

sim: $(prog)
	vvp -n $< -fst #| skipdups

clean:
	rm -f $(prog)

Pins.pdf: Pins.org GNUmakefile
	text2pdf -s8 -c120 -v8 $< >$@
