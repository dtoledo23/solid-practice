package com.solid.practice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.solid.practice.purchase.currency.CurrencyFormatter;
import com.solid.practice.purchase.currency.DefaultCurrencyFormatter;
import com.solid.practice.purchase.date.DateFormatter;
import com.solid.practice.purchase.input.ConsoleInput;
import com.solid.practice.purchase.input.Input;
import com.solid.practice.purchase.output.ConsoleOutput;
import com.solid.practice.purchase.output.Output;

public class ConsolePurchaseProcesorModule implements Module{

	@Override
	public void configure(Binder binder) {
		binder.bind(Input.class).to(ConsoleInput.class);
		binder.bind(Output.class).to(ConsoleOutput.class);
		binder.bind(CurrencyFormatter.class).to(DefaultCurrencyFormatter.class);
		binder.bind(DateFormatter.class).toInstance(new DateFormatter("dd/MM/yyyy"));
	}
}
