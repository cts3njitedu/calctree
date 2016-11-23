package com.scholar.calcweb.demo;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.service.Calculator;
import com.scholar.calcweb.service.MathFunctions;

public class CalcTest {

	public static void main(String[] args) {

		
		 Calculator calculator = new Calculator("5*2*3^2*2");
		 System.out.println(calculator.execute().getResult());
		 
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
