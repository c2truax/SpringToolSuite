package com.codingdojo.phone;

public class PhoneTest {

	public static void main(String[] args) {
		IPhone iPhone = new IPhone("X", 100, "AT&T", "Zing");
		iPhone.displayInfo();
		System.out.println(iPhone.unlock());
		
		Galaxy samsung = new Galaxy("S9", 99, "Verizon", "Ring ring ring");
		samsung.displayInfo();
		System.out.println(samsung.unlock());

	}

}
