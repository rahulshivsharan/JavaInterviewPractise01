package com.multithreading.ex02;

public class MyRunnable01 implements Runnable{
	
	
	private ThreadLocal<Integer> myThreadLocal = null;
	private static final int DURATION = 5000; // 5 seconds
	
	public MyRunnable01() {
		this.myThreadLocal = new ThreadLocal<Integer>() {
			 
			@Override 
			 protected Integer initialValue() {
			        return 1;
			 }
		};
		
	}
	
	@Override
	public void run() {
		try {			
			while(this.myThreadLocal.get() <= 25) {				
				System.out.println(Thread.currentThread().getName()+" [ "+this.myThreadLocal.get()+" ]");
				this.myThreadLocal.set(this.myThreadLocal.get()+1);
				Thread.sleep(MyRunnable01.DURATION);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
