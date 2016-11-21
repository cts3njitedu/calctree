package com.scholar.calcweb.service;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.model.Token;

public class Calculator {

	private CalculateExpression calExpr;
	private Tokenizer tokenizer;
	private ManageTokens manageTokens;
	private String tokenString;

	public Calculator(String tokenString) {
		this.tokenString = tokenString;
		this.tokenizer = new Tokenizer(tokenString);
	}

	public void execute(){
		 
		List<Token> tokenL = createToken();
		calExpr = new CalculateExpression(tokenL);
		calExpr.execute();
		
	}
	public List<Token> createToken() {
		boolean isToken = tokenizer.performTokenizer();
		if (isToken) {
			return tokenizer.getTokenList();
		} else {
			return new LinkedList<Token>();
		}
	}
	
	public void parser(){
	
		
		
	}
}