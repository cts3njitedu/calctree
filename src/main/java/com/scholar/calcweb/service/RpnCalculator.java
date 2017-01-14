package com.scholar.calcweb.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.scholar.calcweb.model.Result;
import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.utility.MathNotation;

public class RpnCalculator {

	private Tokenizer tokenizer;

	public RpnCalculator(String tokenString) {
		this.tokenizer = new Tokenizer(tokenString);
	}

	public Result execute() {

		List<Token> tokenL = createToken();

		List<Token> tokenP = MathNotation.infixToPostfix(tokenL);

		String result = calculate(tokenP);

		return ConstructResponse.getResult(result);

	}

	public String calculate(List<Token> tokenP) {

		Stack<String> valStack = new Stack<String>();
		for (Token t : tokenP) {

			String value = t.getValue();
			String type = t.getType();

			if (type.equals("INT") || type.equals("FLOAT")) {

				valStack.push(value);

			} else {

				String valueR = valStack.pop();
				String valueL = valStack.pop();

				if (value.equals("*")) {

					valStack.push(MathFunctions.multiply(valueL, valueR)[0]);

				} else if (value.equals("+")) {

					valStack.push(MathFunctions.add(valueL, valueR)[0]);

				} else if (value.equals("-")) {

					valStack.push(MathFunctions.subtract(valueL, valueR)[0]);

				} else if (value.equals("/")) {

					valStack.push(MathFunctions.divide(valueL, valueR)[0]);

				} else if (value.equals("%")) {

					valStack.push(MathFunctions.mod(valueL, valueR)[0]);

				} else if (value.equals("^")) {

					valStack.push(MathFunctions.exponent(valueL, valueR)[0]);

				}

			}

		}
		String result = "";
		while (!valStack.isEmpty()) {

			result = valStack.pop();
			break;
		}
		if (!valStack.isEmpty()) {
			return "";
		}
		return result;

	}

	public List<Token> createToken() {
		boolean isToken = tokenizer.performTokenizer();
		if (isToken) {
			return tokenizer.getTokenList();
		} else {
			return new LinkedList<Token>();
		}
	}
}
