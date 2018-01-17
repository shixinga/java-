package com.csx;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConThread extends Thread {
	Exchanger<char[]> mExchanger;
	Random mRandom;
	char[] mBuffer;
	public ConThread(String name,Exchanger<char[]> mExchanger, char [] buffer) {
		super(name);
		this.mExchanger = mExchanger;
		mRandom = new Random();
		mBuffer = buffer;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(Thread.currentThread().getName() + " before change : " + mBuffer);
				mBuffer = mExchanger.exchange(mBuffer);
				System.out.println(Thread.currentThread().getName() + " after change : " + mBuffer);
				System.out.print("consu:");
				for(int i = 0; i < mBuffer.length; ++i) {
					System.out.print(mBuffer[i]);
				}
				System.out.println();
				Thread.sleep(mRandom.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
