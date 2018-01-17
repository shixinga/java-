package com.csx;

public class AutoSaveThread extends Thread {

	private Data mData;

	public AutoSaveThread(String name, Data mData) {
		super(name);
		this.mData = mData;
	}

	@Override
	public void run() {
		while(true) {
			try {
				mData.save();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
