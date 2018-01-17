package com.csx;

import java.util.Random;

public class ProducerThread extends Thread {

	private Table mTable;
	Random mRandom;
	private static int mCakeId = 0;
	public ProducerThread(String name, Table mTable) {
		super(name);
		this.mTable = mTable;
		mRandom = new Random();
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String cake = "No." + nextCakeId() + " maked by " + getName();
			try {
				mTable.put(cake);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static synchronized int nextCakeId() {
		return mCakeId++;
	}
}
