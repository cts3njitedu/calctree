package com.scholar.calcweb.service;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.model.Result;
import com.scholar.calcweb.model.Token;

public class Calculator {

	private CalculateExpression calExpr;
	private Tokenizer tokenizer;

	private String tokenString;

	public Calculator(String tokenString) {
		this.tokenString = tokenString;
		this.tokenizer = new Tokenizer(tokenString);
	}

	public Result execute() {

		List<Token> tokenL = createToken();
		calExpr = new CalculateExpression(tokenL);
		return ConstructResponse.getResult(calExpr.execute());

	}

	public List<Token> createToken() {
		boolean isToken = tokenizer.performTokenizer();
		if (isToken) {
			return tokenizer.getTokenList();
		} else {
			return new LinkedList<Token>();
		}
	}


	public String getTokenString() {
		return tokenString;
	}

}
