package com.scholar.calcweb.service;

public class MathFunctions {

	public static String[] add(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(number1 + number2);

		return checkIntFloat(result);

	}

	public static String addI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 + number2);

		return result;

	}

	public static String[] multiply(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(number1 * number2);

		return checkIntFloat(result);

	}

	public static String multiplyI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 * number2);

		return result;

	}

	public static String[] divide(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(number1 / number2);

		return checkIntFloat(result);

	}

	public static String divideI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 / number2);

		return result;

	}

	public static String[] exponent(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(Math.pow(number1, number2));
		return checkIntFloat(result);

	}

	public static String[] subtract(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(number1 - number2);

		return checkIntFloat(result);

	}

	public static String subtractI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 - number2);

		return result;

	}

	public static String[] mod(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

	
		
		String result = String.valueOf(number1 % number2);
		return checkIntFloat(result);

	}

	public static String[] checkIntFloat(String x) {
		String[] valueType = new String[2];
		if (x.contains(".")) {

			if (x.charAt(x.length() - 1) == '0') {
				valueType[0] = x.substring(0, x.lastIndexOf('.'));
				valueType[1] = "INT";

				return valueType;
			}
			valueType[0] = x;
			valueType[1] = "FLOAT";
			return valueType;
		}
		valueType[0] = x;
		valueType[1] = "INT";
		return valueType;

	}

}
