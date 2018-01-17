package com.csx;

import java.util.Random;

public class ClientThread extends Thread {

	private Channel mChanel;
	private Random mRandom = new Random();
	private volatile boolean mTerminated = false;
	public ClientThread(String name, Channel chanel) {
		super(name);
		this.mChanel = chanel;
	}

	@Override
	public void run() {
		for(int i = 0;!mTerminated; ++i) {
			try {
				Request request = new Request(Thread.currentThread().getName(), i);
				mChanel.putRequest(request);
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
//				e.printStackTrace();
				mTerminated = true;
			}
		}
	}
	
	
	public void stopThread() {
		mTerminated = true;
		interrupt();
	}
	
}
