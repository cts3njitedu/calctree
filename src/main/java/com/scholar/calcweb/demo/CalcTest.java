package com.scholar.calcweb.demo;

import java.util.LinkedList;
import java.util.List;

import com.scholar.calcweb.service.Calculator;

public class CalcTest {

	public static void main(String []args){

		Calculator calculator = new Calculator("5-6");
		System.out.println(calculator.execute());
		
	/*	List<String> temp = new LinkedList<String>();
		
		temp.add("Craig");
		
		temp.add("Theodore");
		temp.add("Steele");
		
		temp.remove(1);
		System.out.println(temp.get(1));*/
	}
}
