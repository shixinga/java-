package com.csx;

import java.util.Random;

public class ChangeThread extends Thread {

	Data mData;
	Random mRandom = new Random();
	public ChangeThread(String name, Data mData) {
		super(name);
		this.mData = mData;
	}

	@Override
	public void run() {
		for(int i = 0; true; ++i) {
			mData.changeContent("no:" + i);
			try {
				Thread.sleep(mRandom.nextInt(1000));
				mData.save();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
}
