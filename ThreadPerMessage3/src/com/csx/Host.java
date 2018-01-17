package com.csx;

import java.util.concurrent.Executor;

public class Host {

	
	private Helper mHandler  = new Helper();
	Executor mExecutor;
	
	
	public Host(Executor mExecutor) {
		this.mExecutor = mExecutor;
	}


	public void request(final int count, final char ch) {
		System.out.println("request (count:" + count + ",ch:" + ch + ") begin!");
		mExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				mHandler.handle(count, ch);
			}
		});
		System.out.println("request (count:" + count + ",ch:" + ch + ") end !");
	}
}
