package com.scholar.calcweb.service;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.reference.Expression;

public class Tokenizer {

	private String tokenString;

	private List<Token> tokenList;

	public Tokenizer(String tokenString) {
		this.tokenString = tokenString.trim();
		this.tokenList = new LinkedList<>();
	}

	public boolean performTokenizer() {
		String token = "";
		boolean isInteger = true;
		boolean isOperator = false;

		for (int i = 0; i < tokenString.length(); i++) {
			char t = tokenString.charAt(i);

			if ((t >= '0' && t <= '9')) {

				if (isOperator) {
					isInteger = true;
				}
				isOperator = false;
				token = token + t;

			} else if (t == '.') {

				token = token + t;
				if (!isOperator) {
					isOperator = false;
					if (isInteger) {
						isInteger = false;
					} else {
						return false;
					}
				} else {
					isInteger = false;
				}
			} else if (t == '+' || t == '*' || t == '%' || t == '^' || t == '/'
					|| t == '-') {
				if ((token.equals("."))) {

					return false;
				}

				if (token.length() > 0) {
					if (isInteger) {

						Token tokenZ = new Token(Expression.INT.name(), token);
						tokenList.add(tokenZ);

					} else {

						Token tokenZ = new Token(Expression.FLOAT.name(), token);
						tokenList.add(tokenZ);
					}
				}
				if (t == '+') {
					Token tokenZ = new Token(Expression.PLUS.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == '*') {
					Token tokenZ = new Token(Expression.STAR.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == '/') {
					Token tokenZ = new Token(Expression.DIV.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == '%') {
					Token tokenZ = new Token(Expression.MOD.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == '^') {
					Token tokenZ = new Token(Expression.EXP.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == '-') {
					Token tokenZ = new Token(Expression.MINUS.name(), t + "");
					tokenList.add(tokenZ);
				}

				isOperator = true;
				isInteger = true;
				token = "";
			} else if (t == '(' || t == ')') {
				if ((token.equals("."))) {

					return false;
				}
				if (token.length() > 0) {
					if (isInteger) {

						Token tokenZ = new Token(Expression.INT.name(), token);
						tokenList.add(tokenZ);

					} else {

						Token tokenZ = new Token(Expression.FLOAT.name(), token);
						tokenList.add(tokenZ);
					}
				}
				if (t == '(') {
					Token tokenZ = new Token(Expression.LPAREN.name(), t + "");
					tokenList.add(tokenZ);
				} else if (t == ')') {
					Token tokenZ = new Token(Expression.RPAREN.name(), t + "");
					tokenList.add(tokenZ);
				}

				isOperator = true;
				isInteger = true;
				token = "";

			} else {
				if(t!=' ')
				return false;
			}
			if (i == tokenString.length() - 1) {

				if ((token.equals("."))) {

					return false;
				}
				if (token.length() > 0) {
					if (isInteger) {

						Token tokenZ = new Token(Expression.INT.name(), token);
						tokenList.add(tokenZ);

					} else {

						Token tokenZ = new Token(Expression.FLOAT.name(), token);
						tokenList.add(tokenZ);
					}
				}
			}
		}
		return true;
	}

	public List<Token> getTokenList() {
		return tokenList;
	}

}
