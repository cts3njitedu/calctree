package com.scholar.calcweb.demo;

import com.scholar.calcweb.service.RpnCalculator;

public class CalcTest {

	public static void main(String[] args) {

		
		/* Calculator calculator = new Calculator("5/3/4");
		 System.out.println(calculator.execute().getResult());*/
		
		
		RpnCalculator calculator = new RpnCalculator("3.8+2.1");
		System.out.println(calculator.execute().getResult());
		
		System.out.println(3.8+2.1);
		 
	/*	Tokenizer token = new Tokenizer("(((9+2)-5*19.78))");
		token.performTokenizerB();
		List<Token>tok = token.getTokenList();
		for(Token t: tok ){
			
			System.out.println(t.getValue());
			
		}*/
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
