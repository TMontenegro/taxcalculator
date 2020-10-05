package com.montenegro.taxcalculator.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.montenegro.taxcalculator.entities.AbstractProduct;
import com.montenegro.taxcalculator.entities.Product;
import com.montenegro.taxcalculator.entities.Receipt;
import com.montenegro.taxcalculator.utils.Utils;

@Service
public class ReceiptService {
	private List<AbstractProduct> abstractProducts = new ArrayList<AbstractProduct>();

	public Receipt create(List<Product> products) {
		this.build(products);

		double totalTaxes = this.sumTaxes();
		
		products = applyTaxesOnProducts();
		
		double totalPrice = this.getTotalPrice();

		return new Receipt(totalPrice, totalTaxes, products);
	}

	public void build(List<Product> products) {
		for (Product product : products) {
			if (AbstractProduct.isExempt(product.getCategory())) 
				this.abstractProducts.add(new ExemptProductService(product));
			
			else 
				this.abstractProducts.add(new NonExemptProductService(product));
		}
	}
	
	public double sumTaxes() {
		double total = this.abstractProducts
							.stream()
							.mapToDouble(product -> product.sumTaxes())
							.sum();

		return Utils.round(total);
	}

	public List<Product> applyTaxesOnProducts() {
		return this.abstractProducts
					.stream()
					.map(product -> product.applyTaxes())
					.collect(Collectors.toList());
	}

	public double getTotalPrice() {
		double total = this.abstractProducts
							.stream()
							.mapToDouble(product -> product.sumTotal())
							.sum();
		
		return Utils.round(total);
	}
}