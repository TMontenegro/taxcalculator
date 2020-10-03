package com.montenegro.taxcalculator.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receipt {
	
	@Positive(message = "Receipt has to have a positive total")
	private double total;
	
	@Positive(message = "Receipt has to have a positive saleTax")
	private double saleTax;
	
	@NotNull(message = "Receipt has to have products")
	private List<Product> products;
	
}
