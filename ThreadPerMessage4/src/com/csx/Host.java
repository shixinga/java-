package com.csx;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Host {

	
	private Helper mHandler  = new Helper();
	ScheduledExecutorService mExecutor;
	
	
	public Host(ScheduledExecutorService mExecutor) {
		this.mExecutor = mExecutor;
	}


	public void request(final int count, final char ch) {
		System.out.println("request (count:" + count + ",ch:" + ch + ") begin!");
		mExecutor.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "!!!!!");
				mHandler.handle(count, ch);				
			}
		}, 2, TimeUnit.SECONDS);
		System.out.println("request (count:" + count + ",ch:" + ch + ") end !");
	}
}
