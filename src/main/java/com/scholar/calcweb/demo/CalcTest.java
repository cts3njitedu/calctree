package com.scholar.calcweb.demo;

import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.service.RpnCalculator;
import com.scholar.calcweb.service.Tokenizer;
import com.scholar.calcweb.utility.MathNotation;

public class CalcTest {

	public static void main(String[] args) {

		
		/* Calculator calculator = new Calculator("5/3/4");
		 System.out.println(calculator.execute().getResult());*/
		
		
		/*RpnCalculator calculator = new RpnCalculator("2^2^(1+2)");
		System.out.println(calculator.execute().getResult());*/
		
		//System.out.println(3.94-5.3);
		 
		
		Tokenizer token = new Tokenizer("(2^3)^2");
		token.performTokenizer();
		List<Token>tok = token.getTokenList();
		List<Token> tokenM = MathNotation.infixToPostfix(tok);
		for(Token t: tokenM ){
			
			System.out.print(t.getValue());
			
		}
	/*	String[] t = MathFunctions.checkIntFloat("50.3");
		
		for(String te: t){
			
			System.out.println(te);
		}*/

		// System.out.println(5%6*5);
		/*
		 * List<String> temp = new LinkedList<String>();
		 * 
		 * temp.add("Craig");
		 * 
		 * temp.add("Theodore"); temp.add("Steele");
		 * 
		 * temp.remove(1); System.out.println(temp.get(1));
		 */
	}
}
