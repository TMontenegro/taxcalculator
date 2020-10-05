package com.montenegro.taxcalculator.entities;

public abstract class AbstractProduct {
	public abstract Product applyTaxes();
	public abstract double sumTaxes();
	public abstract double sumTotal();

	public static boolean isExempt(String category) {
		return category.equals("book") || category.equals("food") || category.equals("medical");
	}
}
