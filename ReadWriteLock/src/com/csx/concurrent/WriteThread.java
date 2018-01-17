package com.csx.concurrent;

import java.util.Random;

public class WriteThread extends Thread {

	private Random mRandom;
	private Data mData;
	private String mFilter;
	private int mIndex = 0;
	public WriteThread(Data mData, String mFilter, long seed) {
		this.mRandom = new Random(seed);
		this.mData = mData;
		this.mFilter = mFilter;
	}
	
	public void run() {
		
		try {
			while(true) {
				char ch;
				ch = nextChar();
				mData.write(ch);
				Thread.sleep(mRandom.nextInt(2000));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private char nextChar() {
		char ch = mFilter.charAt(mIndex);
		mIndex++;
		if(mIndex >= mFilter.length()) {
			mIndex = 0;
		}
		return ch;
	}
}
