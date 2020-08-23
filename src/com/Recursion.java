package com;

public class Recursion {
	
	public static void main(String[] args) {
		System.out.println("generating factorial using recursion !!!");
		System.out.println(factorial(5));
	}

	private static int factorial(int i) {
		System.out.println("i = "+i);
		int fact = 1;
		if(i<=1)
			fact = 1;
		else
			fact = i * factorial(i-1);
		return fact;
	}
}
