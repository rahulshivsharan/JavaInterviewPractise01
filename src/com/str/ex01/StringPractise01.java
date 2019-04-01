package com.str.ex01;

public class StringPractise01 {

	public static void main(String[] args) {
		String s1 = null;
		String s2 = null;
		try {
			s1 = "Hello";
			s2 = "Hello";
			System.out.println("s1 hachcode "+s1.hashCode());
			System.out.println("s2 hachcode "+s2.hashCode());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
