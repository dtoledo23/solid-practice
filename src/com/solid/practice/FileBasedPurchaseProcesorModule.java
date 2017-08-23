package com.solid.practice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.solid.practice.purchase.currency.CurrencyFormatter;
import com.solid.practice.purchase.currency.YenCurrencyFormatter;
import com.solid.practice.purchase.date.DateFormatter;
import com.solid.practice.purchase.input.FileInput;
import com.solid.practice.purchase.input.Input;
import com.solid.practice.purchase.output.FileOutput;
import com.solid.practice.purchase.output.Output;

public class FileBasedPurchaseProcesorModule implements Module {
	
	private final String inputFilename;
	private final String outputFilename;
	
	public FileBasedPurchaseProcesorModule(String inputFilename, String outputFilename) {
		this.inputFilename = inputFilename;
		this.outputFilename = outputFilename;
	}

	@Override
	public void configure(Binder binder) {
		try {
			binder.bind(Input.class).toInstance(new FileInput(inputFilename));
			binder.bind(Output.class).toInstance(new FileOutput(outputFilename));
			binder.bind(CurrencyFormatter.class).to(YenCurrencyFormatter.class);
			binder.bind(DateFormatter.class).toInstance(new DateFormatter("MM-dd-yyyy"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
