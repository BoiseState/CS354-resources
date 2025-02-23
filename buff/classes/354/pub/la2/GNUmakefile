prog?=$(basename $(notdir $(PWD)))

$(prog): test.v [A-Z]*.v monitor
	iverilog -o $@ -s $@ $(filter %.v,$^) -g 2012

sim: $(prog)
	vvp -n $< -fst

clean:
	rm -f $(prog)
