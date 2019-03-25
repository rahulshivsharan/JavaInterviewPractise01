package com.multithreading.ex01;

public class MyRunnable01 implements Runnable{
	
	private int counter = 0;
	private static final int DURATION = 5000; // 5 seconds  
	
	@Override
	public void run() {
		try {
			while(++counter <= 25) {				
				System.out.println(Thread.currentThread().getName()+" [ "+counter+" ]");
				Thread.sleep(MyRunnable01.DURATION);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
