package com.csx;

import java.util.Random;

public class EaterThread extends Thread {

	private Table mTable;
	Random mRandom;
	public EaterThread(String name, Table mTable) {
		super(name);
		this.mTable = mTable;
		mRandom = new Random();
	}

	@Override
	public void run() {
		while(true) {
			try {
				mTable.take();
				Thread.sleep(mRandom.nextInt(1000));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
