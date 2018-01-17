package com.csx;

import java.util.concurrent.TimeoutException;

public class Host {

	private long mTimeout;
	private boolean mReady = false;
	public Host(long mTimeout) {
		this.mTimeout = mTimeout;
	}
	
	public synchronized void setExecutable(boolean on) {
		mReady = on;
		notifyAll();
	}
	
	public synchronized void execute() throws TimeoutException, InterruptedException {
		long startTime = System.currentTimeMillis();
		while(!mReady) {
			long endTime = System.currentTimeMillis();
			long rest = mTimeout - (endTime - startTime);
			if(rest <= 0) {
				throw new TimeoutException("³¬Ê±ÁË ´í´í´í£¡");
			}
			
			wait(rest);
		}
		
		doExecute();
	}

	private void doExecute() {
		System.out.println(Thread.currentThread().getName() + " execute !");
	}
}
