package com.montenegro.taxcalculator.constants;

public enum SALES_TAX {
	BASIC("basic", 0.1), IMPORTED("imported", 0.05);

	private String name;
	private double tax;

	SALES_TAX(String value, double tax) {
		this.name = value;
		this.tax = tax;
	}

	public String getName() {
		return name;
	}

	public double getTax() {
		return tax;
	}
}
