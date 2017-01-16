package com.scholar.calcweb.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.scholar.calcweb.model.Token;

public class MathNotation {

	private static Map<String, Integer> precedence = new HashMap<String, Integer>();

	static {

		precedence.put("+", 1);
		precedence.put("-", 1);
		precedence.put("*", 2);
		precedence.put("/", 2);
		precedence.put("%", 2);
		precedence.put("^", 3);

	}

	public static List<Token> infixToPostfix(List<Token> tokenL) {

		Stack<Token> opStack = new Stack<Token>();

		List<Token> output = new ArrayList<Token>();

		for (Token t : tokenL) {
			String value = t.getValue();
			String type = t.getType();

			if (value.equals("(")) {

				opStack.push(t);

			} else if (value.equals(")")) {

				while (!opStack.isEmpty()) {

					Token curr = opStack.peek();

					String currValue = curr.getValue();
					if (currValue.equals("(")) {

						opStack.pop();
						break;
					} else {

						output.add(opStack.pop());

					}

				}
			} else if (value.equals("*") || value.equals("+")
					|| value.equals("-") || value.equals("/")
					|| value.equals("%") || value.equals("^")) {

				if (opStack.isEmpty() || opStack.peek().getValue().equals("(")) {

					opStack.push(t);
				} else {

					while (!opStack.isEmpty()) {

						Token curr = opStack.peek();

						String currValue = curr.getValue();
						if(currValue.equals("(")){
							opStack.push(t);
							break;
						}

						if(value.equals("^")){
							
							
							if(precedence.get(currValue)>precedence.get(value)){
								
								output.add(curr);

								opStack.pop();
								
							}
							else{
								opStack.push(t);
								break;
								
							}
						}
						
						if ((precedence.get(currValue) >= precedence.get(value))) {
							output.add(curr);

							opStack.pop();
						} else {

							opStack.push(t);
							break;
						}

					}
					if (opStack.isEmpty()) {
						opStack.push(t);
					}
				}
			} else if (type.equals("INT") || type.equals("FLOAT")) {

				output.add(t);
			}

		}
		while (!opStack.isEmpty()) {

			output.add(opStack.pop());
		}

		return output;

	}

}
