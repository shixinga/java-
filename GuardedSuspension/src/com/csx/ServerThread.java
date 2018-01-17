package com.csx;

import java.util.Random;

public class ServerThread extends Thread {

	private Random mRandom;
	private RequestQueue mRequestQueue;
	public ServerThread(RequestQueue mRequestQueue, String name, long seed) {
		super(name);
		this.mRandom = new Random(seed);
		this.mRequestQueue = mRequestQueue;
	}
	@Override
	public void run() {
		for(int i = 0; i < 1000; ++i) {
			Request request = mRequestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " handle " + request.getString());
			
			try {
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
