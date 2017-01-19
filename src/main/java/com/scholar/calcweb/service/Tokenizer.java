package com.scholar.calcweb.service;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.reference.Expression;

public class Tokenizer {

	private String tokenString;

	private List<Token> tokenList;

	public Tokenizer(String tokenString) {
		this.tokenString = tokenString.trim() + "@";
		this.tokenList = new LinkedList<>();
	}

	public boolean performTokenizer() {
		String token = "";
		boolean rParen = false;
	
		for (int i = 0; i < tokenString.length(); i++) {

			char t = tokenString.charAt(i);
			switch (t) {

			case '@':
				if (token.length() == 0) {

					if (i == tokenString.length() - 1) {
						break;
					}
					else
						return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				break;

			case '0':
				token = token + t;
				break;
			case '1':
				token = token + t;
				break;
			case '2':
				token = token + t;
				break;
			case '3':
				token = token + t;
				break;
			case '4':
				token = token + t;
				break;
			case '5':
				token = token + t;
				break;
			case '6':
				token = token + t;
				break;
			case '7':
				token = token + t;
				break;
			case '8':
				token = token + t;
				break;
			case '9':
				token = token + t;
				break;
			case '.':
				token = token + t;
				break;
			case '-':
				if (token.length() == 0) {

					if (!rParen) {
						token = token + t;
						break;
					}
					Token tokenS = new Token(Expression.MINUS.name(), t + "");
					tokenList.add(tokenS);
					token = "";
					rParen = false;
					break;

				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenS = new Token(Expression.MINUS.name(), t + "");
				tokenList.add(tokenS);
				break;
			case '+':
				if (token.length() == 0) {

					if (rParen) {

						Token tokenZ = new Token(Expression.PLUS.name(), t + "");
						tokenList.add(tokenZ);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}

				Token tokenP = new Token(Expression.PLUS.name(), t + "");
				tokenList.add(tokenP);
				break;

			case '*':
				if (token.length() == 0) {

					if (rParen) {

						Token tokenZ = new Token(Expression.STAR.name(), t + "");
						tokenList.add(tokenZ);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenT = new Token(Expression.STAR.name(), t + "");
				tokenList.add(tokenT);
				break;
			case '/':
				if (token.length() == 0) {

					if (rParen) {

						Token tokenZ = new Token(Expression.DIV.name(), t + "");
						tokenList.add(tokenZ);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenD = new Token(Expression.DIV.name(), t + "");
				tokenList.add(tokenD);
				break;
			case '%':
				if (token.length() == 0) {

					if (rParen) {

						Token tokenZ = new Token(Expression.MOD.name(), t + "");
						tokenList.add(tokenZ);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenM = new Token(Expression.MOD.name(), t + "");
				tokenList.add(tokenM);
				break;
			case '^':
				if (token.length() == 0) {

					if (rParen) {

						Token tokenZ = new Token(Expression.EXP.name(), t + "");
						tokenList.add(tokenZ);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenE = new Token(Expression.EXP.name(), t + "");
				tokenList.add(tokenE);
				break;

			case '(':
				if (token.length() == 0) {

					if (rParen) {

						return false;
					}
					Token tokenZ = new Token(Expression.LPAREN.name(), t + "");
					tokenList.add(tokenZ);
					token = "";
					break;

				}
				if(token.equals("-")){
					
					Token tokenZ = new Token(Expression.INT.name(), token + "1");
					tokenList.add(tokenZ);
					
					Token tokenL = new Token(Expression.STAR.name(), "*");
					tokenList.add(tokenL);
					
					Token tokenSS = new Token(Expression.LPAREN.name(), t + "");
					tokenList.add(tokenSS);
					
					token = "";
					break;
					
				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenL = new Token(Expression.LPAREN.name(), t + "");
				tokenList.add(tokenL);
				break;
			case ')':
				if (token.length() == 0) {

					rParen = true;
					Token tokenZ = new Token(Expression.RPAREN.name(), t + "");
					tokenList.add(tokenZ);
					token = "";
					break;

				}
				if (token.contains('.' + "")) {

					Token tokenZ = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				} else {

					Token tokenZ = new Token(Expression.INT.name(), token);
					tokenList.add(tokenZ);
					token = "";

				}
				Token tokenR = new Token(Expression.RPAREN.name(), t + "");
				tokenList.add(tokenR);
				rParen = true;
				break;

			}

		}
		return true;

	}

	public boolean performTokenizerO() {
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
			} else if (t == '-') {

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

					Token tokenZ = new Token(Expression.MINUS.name(), t + "");
					tokenList.add(tokenZ);
					isOperator = true;
					isInteger = true;
					token = "";
				} else {

					isOperator = true;
					isInteger = true;
					token = token + t;
				}

			} else if (t == '+' || t == '*' || t == '%' || t == '^' || t == '/') {
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
				if (t != ' ')
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
