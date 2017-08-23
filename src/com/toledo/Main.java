package com.toledo;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.toledo.purchase.PurchaseProcessor;
import com.toledo.purchase.currency.CurrencyFormatter;
import com.toledo.purchase.currency.DefaultCurrencyFormatter;
import com.toledo.purchase.input.ConsoleInput;
import com.toledo.purchase.input.Input;
import com.toledo.purchase.output.ConsoleOutput;
import com.toledo.purchase.output.Output;

public class Main {
	public static void main(String[] args) {
		Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Input.class).to(ConsoleInput.class);
				binder.bind(Output.class).to(ConsoleOutput.class);
				binder.bind(CurrencyFormatter.class).to(DefaultCurrencyFormatter.class);
			}
		})
		.getInstance(PurchaseProcessor.class)
		.process();
	}
}
