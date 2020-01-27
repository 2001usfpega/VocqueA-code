package com.revature.threadz;

public class ThreadDemo {
	/*
	 * 2 ways to spin up a thread
	 * 1st - extend Thread and overwrite run()
	 * 2nd - Implement Runnable interface and overwrite run()
	 * 
	 */

	public static void main(String[] bettyWhite) {
		Thread extendThread = new ExtendThread();
		Thread implementRunnable = new Thread(new ImplementRunnable());
		implementRunnable.setPriority(10);
		extendThread.start();
		implementRunnable.start();
		for(int i = 0; i <100; i++) {
			System.out.println("Yeehaw - Driver");
		}
		

	}

}
