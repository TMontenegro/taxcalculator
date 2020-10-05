package com.montenegro.taxcalculator.services;

import com.montenegro.taxcalculator.constants.SALES_TAX;
import com.montenegro.taxcalculator.entities.AbstractProduct;
import com.montenegro.taxcalculator.entities.Product;
import com.montenegro.taxcalculator.utils.Utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonExemptProductService extends AbstractProduct {
	Product product;

	public NonExemptProductService(Product product) {
		this.product = product;
	}

	@Override
	public Product applyTaxes() {
		this.product.setPrice(this.product.getPrice() + this.sumTaxes());

		return this.product;
	}

	@Override
	public double sumTaxes() {
		return Utils.round(this.applyBasicTaxOnPrice() + this.applyImportedTaxOnPrice());
	}

	private double applyBasicTaxOnPrice() {
		return this.product.getPrice() * SALES_TAX.BASIC.getTax();
	}

	private double applyImportedTaxOnPrice() {
		if (!this.product.isImported()) return 0.0;

		return this.product.getPrice() * SALES_TAX.IMPORTED.getTax();
	}

	@Override
	public double sumTotal() {
		return this.product.getPrice() * this.product.getAmount();
	}

}
