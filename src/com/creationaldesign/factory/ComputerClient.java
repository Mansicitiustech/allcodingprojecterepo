package com.creationaldesign.factory;

public class ComputerClient {
public static void main(String[] args) {
	
	Computer pc = ComputerFactory.getAllDetailsComputer(ComputerType.PC, "22 GB", "170 GB", "2,27 HGZ", false, true);
	System.out.println("PC Configuration details::"+pc);
	
	Computer server = ComputerFactory.getAllDetailsComputer(ComputerType.Server, "35 GB", "380 GB", "3,49 HGZ", true, false);
	System.out.println("Server Configuration details::"+server);
	
	Computer laptop = ComputerFactory.getAllDetailsComputer(ComputerType.Laptop, "27 GB", "140 GB", "3,23 HGZ", true, true);
	System.out.println("Laptop Configuration details::"+laptop);
	
	System.out.println('A'+'B');
}
}

