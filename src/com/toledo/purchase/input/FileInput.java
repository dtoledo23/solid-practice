package com.toledo.purchase.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput implements Input {
	
	BufferedReader in;
	
	public FileInput(String filename) throws FileNotFoundException {
		in = new BufferedReader(new FileReader(filename));
	}

	@Override
	public String nextLine() {
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
