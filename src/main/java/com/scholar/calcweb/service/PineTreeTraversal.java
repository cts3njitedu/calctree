package com.scholar.calcweb.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.scholar.calcweb.tree.PineTree;

public class PineTreeTraversal {

	private PineTree pineTree;

	public PineTreeTraversal(PineTree pineTree) {
		this.pineTree = pineTree;
	}

	public void execute() {

		calculate(getExpressionStream(parseTree()));
	}

	public Stack<PineTree> parseTree() {

		Stack<PineTree> pineIn = new Stack<PineTree>();
		Stack<PineTree> pineOut = new Stack<PineTree>();

		pineIn.push(pineTree);

		while (!pineIn.isEmpty()) {

			PineTree p = pineIn.pop();

			if (p.getLeft() != null) {
				pineIn.push(p.getLeft());
			}
			if (p.getRight() != null) {
				pineIn.push(p.getRight());
			}

			pineOut.push(p);
			// if(p.getRight()!=null)

		}
		return pineOut;
	}

	public List<PineTree> getExpressionStream(Stack<PineTree> pineTreeS) {
		List<PineTree> pineTreeL = new ArrayList<PineTree>();
		while (!pineTreeS.isEmpty()) {

			pineTreeL.add(pineTreeS.pop());
		}

		return pineTreeL;

	}

	public void calculate(List<PineTree> pineTreeL) {

		for (int i = 0; i < pineTreeL.size(); i++) {

			PineTree pine = pineTreeL.get(i);

			PineTree pineL = pine.getLeft();
			PineTree pineR = pine.getRight();
			if (pine.getType().equals("PLUS")) {
				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.addI(pineL.getValue(),
							pineR.getValue());
					pine.setType("INT");
				}

				else if (pineL.getType().equals("FLOAT")
						|| pineR.getType().equals("FLOAT")) {

					result = MathFunctions.add(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				pine.setValue(result);

			}

			else if (pine.getType().equals("STAR")) {
				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.multiplyI(pineL.getValue(),
							pineR.getValue());
					pine.setType("INT");
				}

				else if (pineL.getType().equals("FLOAT")
						|| pineR.getType().equals("FLOAT")) {

					result = MathFunctions.multiply(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				pine.setValue(result);

			} else if (pine.getType().equals("DIV")) {

				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.divideI(pineL.getValue(),
							pineR.getValue());
					pine.setType("INT");
				}

				else if (pineL.getType().equals("FLOAT")
						|| pineR.getType().equals("FLOAT")) {

					result = MathFunctions.divide(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				pine.setValue(result);

			} else if (pine.getType().equals("MINUS")) {

				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.subtractI(pineL.getValue(),
							pineR.getValue());
					pine.setType("INT");
				}

				else if (pineL.getType().equals("FLOAT")
						|| pineR.getType().equals("FLOAT")) {

					result = MathFunctions.subtract(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				pine.setValue(result);

			} else if (pine.getType().equals("EXP")) {

				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.exponent(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				else if (pineL.getType().equals("FLOAT")
						|| pineR.getType().equals("FLOAT")) {

					result = MathFunctions.exponent(pineL.getValue(),
							pineR.getValue());
					pine.setType("FLOAT");
				}

				pine.setValue(result);

			} else if (pine.getType().equals("MOD")) {

				String result = "";

				if (pineL.getType().equals("INT")
						&& pineR.getType().equals("INT")) {

					result = MathFunctions.mod(pineL.getValue(),
							pineR.getValue());
					pine.setType("INT");
				}
				pine.setValue(result);
			}

		}

	}

	public String getResult() {
		return pineTree.getValue();

	}

}
