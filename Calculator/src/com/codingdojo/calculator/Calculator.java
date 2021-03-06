package com.codingdojo.calculator;

public class Calculator {
	private double result;
	private double numberOne;
	private double numberTwo;
	private String operation;
	
	public Calculator() {
		this.result = 0;
		this.numberOne = 0;
		this.numberTwo = 0;
		this.operation = "";
	}
	
	public void setOperandOne(double num) {
		this.numberOne = num;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setOperandTwo(double num) {
		this.numberTwo = num;
	}
	public void performOperation() {
		if(this.operation.equals("+") == true) {
			this.result = this.numberOne + this.numberTwo;
		} else if(this.operation.equals("-") == true) {
			this.result = this.numberOne - this.numberTwo;
		} else if(this.operation.equals("/") == true) {
			this.result = this.numberOne / this.numberTwo;
		} else if(this.operation.equals("*") == true) {
			this.result = this.numberOne * this.numberTwo;
		} else {
			System.out.println("The operation is not supported");
		}
		this.numberOne = 0;
		this.numberTwo = 0;
		this.operation = "";
	}

	public double getResult() {
		return this.result;
	}

}
