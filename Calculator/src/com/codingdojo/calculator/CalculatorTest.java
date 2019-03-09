package com.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		
		c.setOperandOne(10);
		c.setOperation("*");
		c.setOperandTwo(5);
		
		c.performOperation();
		System.out.println(c.getResult());
	}

}
