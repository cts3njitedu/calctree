package com.scholar.calcweb.service;

import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.tree.PineTree;

public class CalculateExpression {

	private List<Token> tokenList;
	private ManageTokens manageTokens;

	public CalculateExpression(List<Token> tokenList) {
		this.tokenList = tokenList;
		this.manageTokens = new ManageTokens(tokenList);
	}

	public PineTree Expression() {

		PineTree term = Term();

		if (term == null) {

			return null;
		}
		Token token = manageTokens.getToken();

		String value = token.getValue();

		String type = token.getType();
		if (type == "PLUS" || type == "MINUS") {
			PineTree expr = Expression();
			if (expr == null) {
				return null;
			} else {
				return new PineTree(value, term, expr);
			}
		}

		return new PineTree(value, term, null);

	}

	public PineTree Term() {
		PineTree factor = Factor();

		if (factor == null) {

			return null;
		}
		Token token = manageTokens.getToken();

		String value = token.getValue();
		String type = token.getType();
		if (type == "MOD" || type == "STAR" || type == "DIV") {
			PineTree primary = Primary();
			if (primary == null) {
				return null;
			} else {
				return new PineTree(value, factor, primary);
			}
		}

		manageTokens.pushBack();
		return new PineTree(value, factor, null);

	}

	public PineTree Factor() {
		PineTree primary = Primary();

		if (primary == null) {

			return null;
		}
		Token token = manageTokens.getToken();

		String value = token.getValue();
		String type = token.getType();

		if (type == "EXP") {
			PineTree factor = Primary();
			if (factor == null) {
				return null;
			} else {
				return new PineTree(value, primary, factor);
			}
		}

		manageTokens.pushBack();
		return new PineTree(value, primary, null);

	}

	public PineTree Primary() {
		Token token = manageTokens.getToken();

		String value = token.getValue();
		String type = token.getType();
		if (type == "INT" || type == "FLOAT") {

			return new PineTree(value, null, null);
		} else if (type == "LPAREN") {

			PineTree expr = Expression();

			if (expr == null) {
				return null;
			} else {
				Token token2 = manageTokens.getToken();

				String value2 = token2.getValue();
				String type2 = token2.getType();
				if (type2 == "RPAREN") {
					return new PineTree(value, expr, new PineTree(value2, null,
							null));

				}
				else{
					return null;
				}

			}
		}

		return null;
	}
}
