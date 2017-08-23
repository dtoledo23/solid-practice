package com.toledo.purchase.output;

public class ConsoleOutput implements Output {

	@Override
	public void println(String line) {
		System.out.println(line);
	}

}
