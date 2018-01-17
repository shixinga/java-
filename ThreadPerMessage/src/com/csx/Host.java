package com.csx;

public class Host {

	private Helper mHandler  = new Helper();
	public void request(final int count, final char ch) {
		System.out.println("request (count:" + count + ",ch:" + ch + ") begin!");
		new Thread() {

			@Override
			public void run() {
				mHandler.handle(count, ch);
			}
			
		}.start();
		System.out.println("request (count:" + count + ",ch:" + ch + ") end !");
	}
}
