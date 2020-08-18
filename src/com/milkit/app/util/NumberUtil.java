package com.milkit.app.util;

public class NumberUtil {
	
	public static String addComma(int src) {
		return String.format("%,d", src);
	}

	public static boolean isNumeric(String src) {
		return src.chars().allMatch( Character::isDigit);
	}
}
