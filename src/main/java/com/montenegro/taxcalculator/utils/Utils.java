package com.montenegro.taxcalculator.utils;

public class Utils {
	public static double round(double value) {
		double nearestTo5PercentMultiplier = 20.0;
		return Math.round(value * nearestTo5PercentMultiplier) / nearestTo5PercentMultiplier;
	}

	public static double roundToTwoDecimals(double value) {
		double nearestToTwoDecimals = 100.0;
		return Math.round(value * nearestToTwoDecimals) / nearestToTwoDecimals;
	}
}
