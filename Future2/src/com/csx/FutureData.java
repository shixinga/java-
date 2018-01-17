package com.csx;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements IData {
	public FutureData(Callable<RealData> callable) {
		super(callable);
	}

	private boolean mReady = false;
	private IData mReadData;
	
	@Override
	public /*synchronized*/ String getContent() {
			
			/*while(!mReady) {
				try {
					this.wait(); //只会被this.notify()或者this.notifyAll()唤醒，而不是该进程
								//的其它线程唤醒
					System.out.println(Thread.currentThread().getName() + "hahah");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		String content = null;
		try {
			content = get().getContent(); //get()可能会阻塞(直到上面的callable对象的call()执行完才会不阻塞)
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return content;
	}

}
