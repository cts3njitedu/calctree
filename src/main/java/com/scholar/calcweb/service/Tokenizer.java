package com.scholar.calcweb.service;

import java.util.ArrayList;
import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.reference.Expression;

public class Tokenizer {

	private String tokenString;

	private List<Token> tokenList;

	public Tokenizer(String tokenString) {
		this.tokenString = tokenString.trim() + "@";
		this.tokenList = new ArrayList<>();
	}

	public boolean performTokenizer() {
		String token = "";
		boolean rParen = false;
		Token tokenN = null;

		for (int i = 0; i < tokenString.length(); i++) {

			char t = tokenString.charAt(i);
			switch (t) {

			case '@':
				if (token.length() == 0) {

					if (i == tokenString.length() - 1) {
						break;
					} else
						return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
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
					tokenN = new Token(Expression.MINUS.name(), t + "");
					tokenList.add(tokenN);
					token = "";
					rParen = false;
					break;

				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.MINUS.name(), t + "");
				tokenList.add(tokenN);
				break;
			case '+':
				if (token.length() == 0) {

					if (rParen) {

						tokenN = new Token(Expression.PLUS.name(), t + "");
						tokenList.add(tokenN);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}

				tokenN = new Token(Expression.PLUS.name(), t + "");
				tokenList.add(tokenN);
				break;

			case '*':
				if (token.length() == 0) {

					if (rParen) {

						tokenN = new Token(Expression.STAR.name(), t + "");
						tokenList.add(tokenN);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.STAR.name(), t + "");
				tokenList.add(tokenN);
				break;
			case '/':
				if (token.length() == 0) {

					if (rParen) {

						tokenN = new Token(Expression.DIV.name(), t + "");
						tokenList.add(tokenN);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.DIV.name(), t + "");
				tokenList.add(tokenN);
				break;
			case '%':
				if (token.length() == 0) {

					if (rParen) {

						tokenN = new Token(Expression.MOD.name(), t + "");
						tokenList.add(tokenN);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.MOD.name(), t + "");
				tokenList.add(tokenN);
				break;
			case '^':
				if (token.length() == 0) {

					if (rParen) {

						tokenN = new Token(Expression.EXP.name(), t + "");
						tokenList.add(tokenN);
						rParen = false;
						token = "";
						break;
					}

					return false;
				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.EXP.name(), t + "");
				tokenList.add(tokenN);
				break;

			case '(':
				if (token.length() == 0) {

					if (rParen) {

						return false;
					}
					tokenN = new Token(Expression.LPAREN.name(), t + "");
					tokenList.add(tokenN);
					token = "";
					break;

				}
				if (token.equals("-")) {

					tokenN = new Token(Expression.INT.name(), token + "1");
					tokenList.add(tokenN);

					tokenN = new Token(Expression.STAR.name(), "*");
					tokenList.add(tokenN);

					tokenN = new Token(Expression.LPAREN.name(), t + "");
					tokenList.add(tokenN);

					token = "";
					break;

				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.LPAREN.name(), t + "");
				tokenList.add(tokenN);
				break;
			case ')':
				if (token.length() == 0) {

					rParen = true;
					tokenN = new Token(Expression.RPAREN.name(), t + "");
					tokenList.add(tokenN);
					token = "";
					break;

				}
				if (token.contains('.' + "")) {

					tokenN = new Token(Expression.FLOAT.name(), token);
					tokenList.add(tokenN);
					token = "";

				} else {

					tokenN = new Token(Expression.INT.name(), token);
					tokenList.add(tokenN);
					token = "";

				}
				tokenN = new Token(Expression.RPAREN.name(), t + "");
				tokenList.add(tokenN);
				rParen = true;
				break;

			}

		}
		return true;

	}

	public List<Token> getTokenList() {
		return tokenList;
	}

}
