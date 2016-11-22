package com.scholar.calcweb.tree;

public class PineTree {

	private String value;
	private String type;
	private PineTree left;
	private PineTree right;

	public PineTree(String value, String type, PineTree left, PineTree right) {
		this.value = value;
		this.type = type;
		this.left = left;
		this.right = right;
	}

	public String getValue() {
		return value;
	}

	public PineTree getLeft() {
		return left;
	}

	public PineTree getRight() {
		return right;
	}

	public String getType() {
		return type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLeft(PineTree left) {
		this.left = left;
	}

	public void setRight(PineTree right) {
		this.right = right;
	}

}
