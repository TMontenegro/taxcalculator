package com.montenegro.taxcalculator.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.montenegro.taxcalculator.entities.Product;
import com.montenegro.taxcalculator.entities.Receipt;

@Service
public class ReceiptService {
	
	public Receipt create(List<Product> products) {
		return new Receipt(this.sumTotal(products), this.sumTaxes(products), this.applyTaxes(products));
	}
	
	public List<Product> applyTaxes(List<Product> products) {
		return products;
	}

	
	public double sumTotal(List<Product> products) {
		return 0;
	}

	
	public double sumTaxes(List<Product> products) {
		return 0;
	}
	
}
