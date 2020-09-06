package com.java.problems.sorting;

import com.java.problems.entity.A;

public class C extends A {

	int x;
	final int a;

	public C() {
//		this(10);
		super();
		a = 10;
		System.out.println("in C");
	}

	public C(int x) {
		this.x = 10;
		this.a = 100;
	}
	/*
	 * public void check() { // C c = new C(); }
	 */

	static {
		System.out.println("Hello world!");
	}

	static void add(double a, double b) {
		System.out.println("double double");
	}

	static void add(long a, long b) {
		System.out.println("long long");
	}

	public static void main(String args[]) {
		/*
		 * // C.add(20, 20); C c= new C(); c.display();
		 */
		C c = new C(10);
//		System.out.println(c.x);
//		A a = c;
		System.out.println(c.a);
		C c1 = new C();
		System.out.println(c1.a);
		A c3 = new C();
		c3.drive();
		System.out.println(c3 instanceof A);
		A a = new C();
		C c4 = (C) a;
		c4.drive();

//		C.method(a);

	}

	/*
	 * static void method(A a) { C c = (C) a; System.out.println("Downcasting"); }
	 */

	/*
	 * public C() { super.display();
	 * 
	 * }
	 */

	public void drive() {
		System.out.println("C driving");
	}

	public C display() {

		System.out.println("in C");
		return new C();
	}

	final void draw() {

	}

	final void finalMethod() {

	}

	final void finalMethod(int x) {

	}
}

interface I {
	public void draw();
}

abstract class K implements I {
	public void draw() {

	}
	
	abstract void check();
}
