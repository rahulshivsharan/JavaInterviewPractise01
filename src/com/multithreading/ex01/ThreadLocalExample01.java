package com.multithreading.ex01;

public class ThreadLocalExample01 {

	
	
	public static void main(String[] args) {
		Thread [] threadList = null;
		MyRunnable01 runnableObj = null;
		try {
			runnableObj = new MyRunnable01();
			threadList = new Thread [] {
				new Thread(runnableObj,"T-1"),
				new Thread(runnableObj,"T-2"),
				new Thread(runnableObj,"T-3"),
				new Thread(runnableObj,"T-4"),
				new Thread(runnableObj,"T-5")
			};
			
			for(Thread t : threadList) {
				t.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
