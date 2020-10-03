package com.montenegro.taxcalculator.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.montenegro.taxcalculator.entities.Product;
import com.montenegro.taxcalculator.entities.Receipt;
import com.montenegro.taxcalculator.services.ReceiptService;

@RestController
public class ReceiptController {

	private ReceiptService receiptService;

	@Autowired
	public ReceiptController(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public @ResponseBody Receipt create(@Valid @RequestBody List<Product> products) throws Exception {
		return this.receiptService.create(products);
	}

}
