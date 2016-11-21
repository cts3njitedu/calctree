package com.scholar.calcweb.demo;

import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.service.Tokenizer;

public class CalcTest {

	public static void main(String []args){

		Tokenizer tokenizer = new Tokenizer("             (       4 +.                2)*3               ");
		boolean isTokens = tokenizer.performTokenizer();
		
		if(isTokens){
			List<Token> tokenList = tokenizer.getTokenList();
			
			for(int i =0; i<tokenList.size();i++){
				Token t = tokenList.get(i);
				System.out.println(t.getType()+":" + t.getValue());
			}
		}
	}
}
