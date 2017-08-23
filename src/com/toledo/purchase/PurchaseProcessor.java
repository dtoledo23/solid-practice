package com.toledo.purchase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.toledo.purchase.input.Input;

public class PurchaseProcessor {
	
	@Inject private Input input;
	@Inject private PurchaseReporter purchaseReporter;

	public void process() {
		List<Purchase> purchases = new ArrayList<>();
		
		int purchasesCount = Integer.parseInt(input.nextLine());
		
		for(int i = 0; i < purchasesCount; i++) {
			purchases.add(Purchase.parseFrom(input.nextLine()));
		}
		
		input.close();
		
		purchaseReporter.printReport(purchases);
	}
	
}
