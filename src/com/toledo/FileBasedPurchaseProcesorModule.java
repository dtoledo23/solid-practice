package com.toledo;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.toledo.purchase.currency.CurrencyFormatter;
import com.toledo.purchase.currency.YenCurrencyFormatter;
import com.toledo.purchase.date.DateFormatter;
import com.toledo.purchase.input.FileInput;
import com.toledo.purchase.input.Input;
import com.toledo.purchase.output.FileOutput;
import com.toledo.purchase.output.Output;

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
