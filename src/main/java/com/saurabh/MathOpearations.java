package com.saurabh;

public class MathOpearations {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int devide(int a, int b) {
		return a / b;
	}

	public double computeCirleRadius(double radius) {
		double area = Math.PI * radius * radius;
		System.out.println("Area is  " + area);
		return area;
	}

}
