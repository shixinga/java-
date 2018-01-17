package com.csx;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProThread extends Thread {

	Exchanger<char[]> mExchanger;
	Random mRandom;
	char[] mBuffer;
	int mIndex = 0;
	public ProThread(String name,Exchanger<char[]> mExchanger, char [] buffer) {
		super(name);
		this.mExchanger = mExchanger;
		mRandom = new Random();
		mBuffer = buffer;
	}
	
	public void run() {
		while(true) {
			System.out.print("pro:");
			for(int i = 0; i < mBuffer.length; ++i) {
				mBuffer[i] = nextChar();
				System.out.print(mBuffer[i]);
			}
			System.out.println();
			try {
				System.out.println(Thread.currentThread().getName() + " before change : " + mBuffer);
				mBuffer = mExchanger.exchange(mBuffer);
				System.out.println(Thread.currentThread().getName() + " after change : " + mBuffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private char nextChar() {
		char c = (char) ('A' + mIndex);
		mIndex++;
		try {
			Thread.sleep(mRandom.nextInt(50));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return c;
	}
}
