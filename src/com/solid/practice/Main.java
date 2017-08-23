package com.solid.practice;

import com.google.inject.Guice;
import com.solid.practice.purchase.PurchaseProcessor;

public class Main {
	public static void main(String[] args) {
		Guice.createInjector(
				// Use whatever module you want to change behavior.
				// new ConsolePurchaseProcesorModule())
				new FileBasedPurchaseProcesorModule("input.txt", "output.txt"))
		.getInstance(PurchaseProcessor.class)
		.process();
	}
}
