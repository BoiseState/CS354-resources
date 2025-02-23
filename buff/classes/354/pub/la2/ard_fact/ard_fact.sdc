create_clock -period 15 -name CLK66 CLK66
create_generated_clock -divide_by 10 -source [get_ports CLK66] -name CLK [get_registers Clk:clk|Gen]
