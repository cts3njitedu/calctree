package com.scholar.calcweb.tree;

public class PineTree {

	private String value;
	private String type;
	private String preValue;
	private String preType;
	private PineTree left;
	private PineTree right;


	public PineTree(String value, String type, String preValue, String preType,
			PineTree left, PineTree right) {
		this.value = value;
		this.type = type;
		this.preValue = preValue;
		this.preType = preType;
		this.left = left;
		this.right = right;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPreValue() {
		return preValue;
	}


	public void setPreValue(String preValue) {
		this.preValue = preValue;
	}


	public String getPreType() {
		return preType;
	}


	public void setPreType(String preType) {
		this.preType = preType;
	}


	public PineTree getLeft() {
		return left;
	}


	public void setLeft(PineTree left) {
		this.left = left;
	}


	public PineTree getRight() {
		return right;
	}


	public void setRight(PineTree right) {
		this.right = right;
	}



}
