package com.montenegro.taxcalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.montenegro.taxcalculator.builder.ProductDTO;
import com.montenegro.taxcalculator.entities.Product;
import com.montenegro.taxcalculator.entities.Receipt;
import com.montenegro.taxcalculator.services.ReceiptService;

class ReceiptServiceTest {

	@Autowired
	ReceiptService receiptService = new ReceiptService();

	@Test
	void bookFoodAndMedicalProductMustNotBeTaxed() {
		List<Product> exemptProducts = this.getExemptProducts();

		Receipt receipt = this.receiptService.create(exemptProducts);

		assertEquals(0.0, receipt.getSaleTax());
		assertEquals(28.33, receipt.getTotal());
	}

	@Test
	void nonExemptProductMustBeTaxedAt10Percent() {
		List<Product> nonExemptProducts = this.getNonExemptProducts();

		Receipt receipt = this.receiptService.create(nonExemptProducts);

		assertEquals(5.75, receipt.getSaleTax());
		assertEquals(63.25, receipt.getTotal());
	}

	@Test
	void importedProductMustBeTaxedAt5Percent() {
		List<Product> importedProducts = this.getExemptImportedProducts();

		Receipt receipt = this.receiptService.create(importedProducts);

		assertEquals(1.41, receipt.getSaleTax());
		assertEquals(29.74, receipt.getTotal());
	}

	@Test
	void nonExemptImportedProductMustBeTaxedAsImportedProductAndAsNotExemptProduct() {
		List<Product> nonExemptImportedProducts = this.getNonExemptImportedProducts();

		Receipt receipt = this.receiptService.create(nonExemptImportedProducts);

		assertEquals(8.65, receipt.getSaleTax());
		assertEquals(66.15, receipt.getTotal());
	}

	private List<Product> getExemptProducts() {
		return new ProductDTO().createProductList()
				.addProduct(false, 12.49, 1, "book", "book")
				.addProduct(false, 14.99, 1, "medicine", "medicine")
				.addProduct(false, 0.85, 1, "food", "food")
				.build();
	}

	private List<Product> getNonExemptProducts() {
		return new ProductDTO().createProductList()
				.addProduct(false, 10.00, 1, "perfume", "perfume")
				.addProduct(false, 47.50, 1, "cd", "cd")
				.build();
	}

	private List<Product> getExemptImportedProducts() {
		return new ProductDTO().createProductList()
				.addProduct(true, 12.49, 1, "book", "book")
				.addProduct(true, 14.99, 1, "medicine", "medicine")
				.addProduct(true, 0.85, 1, "food", "food")
				.build();
	}

	private List<Product> getNonExemptImportedProducts() {
		return new ProductDTO().createProductList()
				.addProduct(true, 10.00, 1, "perfume", "perfume")
				.addProduct(true, 47.50, 1, "cd", "cd")
				.build();
	}
}
