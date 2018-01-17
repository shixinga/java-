package com.csx;

import java.util.concurrent.Callable;

public class Host {

	public IData handleRequest(final int count, final char ch) {
		System.out.println(Thread.currentThread() + " request " + count + " " + ch + " begin!");
		final FutureData futureData = new FutureData(new Callable<RealData>() {
			
			@Override
			public RealData call() throws Exception {
				return new RealData(count, ch);
			}
		});
		new Thread(futureData).start();
		
		System.out.println(Thread.currentThread() + " request " + count + " " + ch + " end!");
		return futureData;
	}
}
