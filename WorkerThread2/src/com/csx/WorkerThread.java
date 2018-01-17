package com.csx;

import java.util.Random;
/**
 * 和Producer-Consumer代码一样，只是名字换了
 * 
 * @author csx
 *
 */
public class WorkerThread extends Thread {

	Channel mChannel;
	Random mRandom = new Random();
	
	private volatile boolean mTerminated = false;
	
	public WorkerThread(String name, Channel channel) {
		super(name);
		mChannel = channel;
	}

	@Override
	public void run() {
		while(!mTerminated) {
			try {
				Request request = mChannel.handleRequest();
				request.execute();
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
