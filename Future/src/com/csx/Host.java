package com.csx;

public class Host {

	public IData handleRequest(final int count, final char ch) {
		System.out.println(Thread.currentThread() + " request " + count + " " + ch + " begin!");
		final FutureData futureData = new FutureData();
		new Thread() {

			@Override
			public void run() {
				RealData realData = new RealData(count, ch);
				futureData.setData(realData);
			}
			
		}.start();
		
		System.out.println(Thread.currentThread() + " request " + count + " " + ch + " end!");
		return futureData;
	}
}
