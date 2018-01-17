package com.csx;

import java.util.Random;

public class ClientThread extends Thread {

	private RequestQueue mRequestQueue;
	Random mRandom;
	public ClientThread(RequestQueue mRequestQueue, String name, long seed) {
		super(name);
		this.mRequestQueue = mRequestQueue;
		mRandom = new Random(seed);
	}
	@Override
	public void run() {
		for(int i = 0; i < 1000; ++i) {
			Request request = new Request(" NO." + i);
			System.out.println(Thread.currentThread().getName() + " request " + request.getString());
			mRequestQueue.putRequest(request);
			
			try {
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
