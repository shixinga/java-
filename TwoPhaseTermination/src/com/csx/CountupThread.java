package com.csx;

public class CountupThread extends Thread {

	private int mCount = 0;
	private volatile boolean mIsShutdown = false;
	
	public boolean isShutdown() {
		return mIsShutdown;
	}
	
	public void shutdown() {
		mIsShutdown = true;
		interrupt();
	}
	
	@Override
	public void run() {
			try {
				while(!isShutdown()) {
					System.out.println("count:" + mCount++);
					Thread.sleep(250);
				}
			} catch (InterruptedException e) {
//				e.printStackTrace();
			} finally {
				doShutdown();
			}
	}

	private void doShutdown() {
		System.out.println(Thread.currentThread().getName() + " shutdown!!!");
	}

	
	
}
