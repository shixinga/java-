package com.csx;

import java.util.concurrent.ThreadFactory;

public class Host {

	ThreadFactory mThreadFactory;
	private Helper mHandler  = new Helper();
	
	
	public Host(ThreadFactory mThreadFactory) {
		this.mThreadFactory = mThreadFactory;
	}


	public void request(final int count, final char ch) {
		System.out.println("request (count:" + count + ",ch:" + ch + ") begin!");
		mThreadFactory.newThread(new Runnable() {
			
			@Override
			public void run() {
				mHandler.handle(count, ch);				
			}
		}).start();
		System.out.println("request (count:" + count + ",ch:" + ch + ") end !");
	}
}
