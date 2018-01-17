package com.csx;

public class ClientThread extends Thread {

	
	public ClientThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + " begin1");
		for(int i = 0; i < 10; ++i) {
			Log.printLn("i=" + i);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.close();
		System.out.println(getName()+ "end1");
	}

	
}
