prog?=$(basename $(notdir $(PWD)))

%.mon: %.in ; genprintf $<

$(prog): test.v [A-Z]*.v monitor.mon
	iverilog -o $@ -s $@ $(filter %.v,$^) -g 2012

sim: $(prog)
	vvp -n $< -fst

clean:
	rm -f $(prog)
