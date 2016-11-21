package com.scholar.calcweb.service;

import java.util.List;

import com.scholar.calcweb.model.Token;

public class ManageTokens {

	private List<Token> tokenList;

	private int counter;

	public ManageTokens(List<Token> tokenList) {
		this.tokenList = tokenList;
		this.counter = 0;
	}

	public Token getToken() {

		Token token = tokenList.get(counter);
		counter++;
		return token;
	}
	
	public void pushBack(){
		
		counter--;
	}
	public int getCounter(){
		return counter;
	}

}
