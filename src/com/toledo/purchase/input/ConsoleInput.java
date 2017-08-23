package com.toledo.purchase.input;

import java.util.Scanner;

public class ConsoleInput implements Input{
	
	private Scanner in;
	
	public ConsoleInput() {
		in = new Scanner(System.in);
	}
	
	@Override
	public String nextLine() {
		return in.nextLine();
	}

	@Override
	public void close() {
		in.close();
		
	}

}
