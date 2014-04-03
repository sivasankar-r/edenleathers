package com.kanchutech.eden.util;

public class MathUtil {
	public static double addItemToAvg(double currentAvg, int currentItemsCount, double newItemVal){
		return roundUptoTwoPlaces(((currentAvg * currentItemsCount)+newItemVal)/(currentItemsCount+1));
	}
	
	public static double roundUptoTwoPlaces(double value){
		return (double) Math.round(value * 100) / 100;
	}

	public static double removeItemFromAvg(double currAvg, int currentItemsCount, double itemVal) {
		return roundUptoTwoPlaces(((currAvg*currentItemsCount) - itemVal)/(currentItemsCount -1));
	}
}
