package com.csx;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundResource {

	private final Semaphore mSemaphore;
	private final int mPermits;
	private final static Random mRandom = new Random(314155);
	public BoundResource(int permits) {
		this.mSemaphore = new Semaphore(permits);
		this.mPermits = permits;
	}
	
	public void use() {
		try {
			mSemaphore.acquire();
			doUse();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			mSemaphore.release();
		}
		
	}

	private void doUse() throws InterruptedException {

		Log.log("begin used=" + (mPermits - mSemaphore.availablePermits()));
		Thread.sleep(mRandom.nextInt(500));
		Log.log("end used=" + (mPermits - mSemaphore.availablePermits()));
	}
	
	
}
