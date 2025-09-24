prog:=test

$(prog): $(prog).v [A-Z]*.v ard_*.v monitor
	iverilog -o $@ -s $@  $(filter %.v,$^) -g 2012

sim: $(prog)
	vvp -n $< -fst

clean:
	rm -f $(prog)
