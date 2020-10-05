package com.montenegro.taxcalculator.entities;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Receipt {
	
	private double total;
	private double saleTax;
	private List<Product> products;
}
