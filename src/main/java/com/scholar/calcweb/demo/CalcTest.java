package com.scholar.calcweb.demo;

import com.scholar.calcweb.service.Calculator;

public class CalcTest {

	public static void main(String []args){

		Calculator calculator = new Calculator("5*(4+3)");
		calculator.execute();
	}
}
