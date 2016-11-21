package com.scholar.calcweb.service;

import java.util.List;

import com.scholar.calcweb.model.Token;
import com.scholar.calcweb.tree.PineTree;

public class CalculateExpression {

	private List<Token> tokenList;
	private ManageTokens manageTokens;

	private int tokenListCard;

	public CalculateExpression(List<Token> tokenList) {
		this.tokenList = tokenList;
		this.manageTokens = new ManageTokens(tokenList);

		this.tokenListCard = tokenList.size() - 1;
	}

	public void execute() {

		PineTree result = Expression();
		
		System.out.println(result);
	}

	public PineTree Expression() {

		PineTree term = Term();

		if (term == null) {

			return null;
		}
		if (manageTokens.getCounter() > tokenListCard) {

			return term;

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

		manageTokens.pushBack();
		return term;

	}

	public PineTree Term() {
		PineTree factor = Factor();

		if (factor == null) {

			return null;
		}
		if (manageTokens.getCounter() > tokenListCard) {

			return factor;

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
		return factor;

	}

	public PineTree Factor() {
		PineTree primary = Primary();

		if (primary == null) {

			return null;
		}
		if (manageTokens.getCounter() > tokenListCard) {

			return primary;

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
		return primary;

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

				} else {
					return null;
				}

			}
		}

		return null;
	}
}
