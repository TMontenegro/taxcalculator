package com.montenegro.taxcalculator.utils;

public class Utils {
	public static double round(double value) {
		double closestToFivePercent = 20.0;
		return Math.round(value * closestToFivePercent) / closestToFivePercent;
	}

	public static double roundToTwoDecimals(double value) {
		double closestToTwoDecimals = 100.0;
		return Math.round(value * closestToTwoDecimals) / closestToTwoDecimals;
	}
}
