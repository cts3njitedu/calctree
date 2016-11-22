package com.scholar.calcweb.service;

public class MathFunctions {

	public static String add(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		String result = String.valueOf(number1 + number2);

		return result;

	}

	public static String addI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 + number2);

		return result;

	}

	public static String multiply(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		return String.valueOf(number1 * number2);

	}

	public static String multiplyI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 * number2);

		return result;

	}

	public static String divide(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		return String.valueOf(number1 / number2);

	}

	public static String divideI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 / number2);

		return result;

	}

	public static String exponent(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		return String.valueOf(Math.pow(number1, number2));

	}


	public static String subtract(String x, String y) {

		float number1 = Float.parseFloat(x);
		float number2 = Float.parseFloat(y);

		return String.valueOf(number1 - number2);

	}

	public static String subtractI(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		String result = String.valueOf(number1 - number2);

		return result;

	}

	public static String mod(String x, String y) {

		int number1 = Integer.parseInt(x);
		int number2 = Integer.parseInt(y);

		return String.valueOf(number1 % number2);

	}

}
