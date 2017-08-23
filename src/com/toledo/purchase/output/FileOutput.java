package com.toledo.purchase.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput implements Output {
	
	private PrintWriter printWriter;

	public FileOutput(String filename) throws FileNotFoundException {
		printWriter = new PrintWriter(filename);
	}

	@Override
	public void println(String line) {
		printWriter.println(line);
		printWriter.flush();
	}
}
