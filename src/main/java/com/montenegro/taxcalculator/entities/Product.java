package com.montenegro.taxcalculator.entities;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	
	@NotNull(message = "Product has to be imported or not.")
	private boolean imported;

	@Positive(message = "Product has to have a positive price.")
	private double price;

	@Positive(message = "Product has to have a positive amount.")
	private Integer amount;

	@NotNull(message = "Product has to have a category.")
	@NotBlank(message = "Product category value cannot be empty.")
	private String category;

	@NotNull(message = "Product has to have a description.")
	@NotBlank(message = "Product description value cannot be empty.")
	private String description;
	
}
