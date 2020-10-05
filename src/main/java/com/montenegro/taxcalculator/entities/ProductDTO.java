package com.montenegro.taxcalculator.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
	
	private List<Product> products;

	public ProductDTO createProductList() {
		this.products = new ArrayList<Product>();
		return this;
	}

	public ProductDTO addProduct(boolean isImported, double price, int amount, String category, String description) {
		this.products.add(new Product(isImported, price, amount, category, description));
		return this;
	}

	public List<Product> build() {
		return this.products;
	}
	
}
