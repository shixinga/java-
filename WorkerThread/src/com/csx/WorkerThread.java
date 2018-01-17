package com.csx;

import java.util.Random;

public class WorkerThread extends Thread {

	Channel mChannel;
	Random mRandom = new Random();
	public WorkerThread(String name, Channel channel) {
		super(name);
		mChannel = channel;
	}

	@Override
	public void run() {
		while(true) {
			Request request = mChannel.handleRequest();
			request.execute();
			try {
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
