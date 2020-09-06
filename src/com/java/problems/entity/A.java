package com.java.problems.entity;

public class A {

	private int privateVariable;
	
	public int publicVariable;
	
	protected int protectedVariable;

	public int getPrivateVariable() {
		return privateVariable;
	}

	public void setPrivateVariable(int privateVariable) {
		this.privateVariable = privateVariable;
	}

	public int getPublicVariable() {
		return publicVariable;
	}

	public void setPublicVariable(int publicVariable) {
		this.publicVariable = publicVariable;
	}
	
	public A display() {
		System.out.println("in A");
		return new A();
	}
	
	public void check() {
		
	}
	public A() {
		super();
		System.out.println("in A");
	}
	
	public void drive() {
		System.out.println("A driving");
	}
}
