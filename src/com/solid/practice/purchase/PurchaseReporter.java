package com.solid.practice.purchase;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.solid.practice.purchase.currency.CurrencyFormatter;
import com.solid.practice.purchase.date.DateFormatter;
import com.solid.practice.purchase.output.Output;

public class PurchaseReporter {
	
	@Inject private Output output;
	@Inject private CurrencyFormatter currencyFormatter;
	@Inject private DateFormatter dateFormatter;

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

		output.println("Purchases of " + dateFormatter.format(new Date()));
		output.println(formatReportEntry("Min", min));
		output.println(formatReportEntry("Max", max));
		output.println(formatReportEntry("Avg", avg));
		output.println("Frequent Payee: " + frequent);
	}
}
