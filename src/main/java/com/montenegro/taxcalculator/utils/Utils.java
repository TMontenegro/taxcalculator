package com.montenegro.taxcalculator.utils;

public class Utils {
	public static double round(double value) {
		double nearestTo5PercentMultiplier = 20.0;
		return Math.round(value * nearestTo5PercentMultiplier) / nearestTo5PercentMultiplier;
	}
}
