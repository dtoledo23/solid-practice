package com.solid.practice.purchase.currency;

import java.text.NumberFormat;

public class DefaultCurrencyFormatter implements CurrencyFormatter {

	@Override
	public String format(Double ammount) {
		return NumberFormat.getCurrencyInstance().format(ammount);
	}

}
