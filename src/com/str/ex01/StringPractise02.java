package com.str.ex01;

public class StringPractise02 {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		System.out.println("s1 hashcode "+s1.hashCode());
		System.out.println("s2 hashcode "+s2.hashCode());
		System.out.println(s1 == s2);		
	}

}
