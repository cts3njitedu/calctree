package com.scholar.calcweb.demo;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.service.Calculator;

public class CalcTest {

	public static void main(String []args){

		Calculator calculator = new Calculator("2^2^3");
		System.out.println(calculator.execute().getResult());
		
		//System.out.println(5%6*5);
	/*	List<String> temp = new LinkedList<String>();
		
		temp.add("Craig");
		
		temp.add("Theodore");
		temp.add("Steele");
		
		temp.remove(1);
		System.out.println(temp.get(1));*/
	}
}
