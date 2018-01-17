package com.csx;

public class ReadThread extends Thread {

	private Data mData;

	public ReadThread(Data data) {
		this.mData = data;
	}
	
	public void run() {
		try {
			while(true) {
				char [] buffer = mData.read();
				System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(buffer));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
