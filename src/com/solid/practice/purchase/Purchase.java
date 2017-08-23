package com.solid.practice.purchase;

import java.util.Scanner;

public class Purchase implements Comparable<Purchase> {
	private String payee;
	private Double price;
	
	public static Purchase parseFrom(String input) {
		Scanner sc = new Scanner(input);
		String name = sc.next();
		Double price = sc.nextDouble();
		sc.close();
		return new Purchase(name, price);
	}
	
	private Purchase(String payee, Double price) {
		this.payee = payee;
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getPayee() {
		return payee;
	}

	@Override
	public int compareTo(Purchase o) {
		if (this.price == o.price) {
			return this.payee.compareTo(o.payee);
		}
		return this.price.compareTo(o.price);
	}
	
	public String toString() {
		return payee + ": $" + price; 
	}
	
}
