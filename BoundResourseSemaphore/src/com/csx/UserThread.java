package com.csx;

import java.util.Random;

public class UserThread extends Thread{

	Random mRandom = new Random(26535);
	private BoundResource mBoundResource;
	
	
	
	public UserThread(BoundResource mBoundResource) {
		this.mBoundResource = mBoundResource;
	}

	

	@Override
	public void run() {
		while(true) {
			mBoundResource.use();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
