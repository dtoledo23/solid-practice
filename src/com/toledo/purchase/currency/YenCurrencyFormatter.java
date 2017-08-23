package com.toledo.purchase.currency;

import java.text.NumberFormat;
import java.util.Locale;

public class YenCurrencyFormatter implements CurrencyFormatter {

	@Override
	public String format(Double ammount) {
		return "¥" + NumberFormat.getInstance(Locale.JAPAN).format(ammount);
	}

}
