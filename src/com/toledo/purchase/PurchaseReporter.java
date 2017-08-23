package com.toledo.purchase;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.toledo.purchase.currency.CurrencyFormatter;
import com.toledo.purchase.output.Output;

public class PurchaseReporter {
	
	@Inject private Output output;
	@Inject private CurrencyFormatter currencyFormatter;

	private String formatReportEntry(String message, Double ammount) {
		return message + ": " + currencyFormatter.format(ammount);
	}

	public void printReport(List<Purchase> purchases) {
		Collections.sort(purchases);

		Purchase highest = purchases.get(purchases.size() - 1);
		Purchase lowest = purchases.get(0);

		Double max = highest.getPrice();
		Double min = lowest.getPrice();
		Double avg = purchases.stream().mapToDouble(Purchase::getPrice).average().getAsDouble();

		String frequent = purchases.stream().map(Purchase::getPayee)
				.collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet().stream()
				.max(Comparator.comparing(Entry::getValue)).get().getKey();

		output.println("Purchases of " + new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		output.println(formatReportEntry("Min", min));
		output.println(formatReportEntry("Max", max));
		output.println(formatReportEntry("Avg", avg));
		output.println("Frequent Payee: " + frequent);
	}
}
