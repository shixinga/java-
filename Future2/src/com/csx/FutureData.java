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
					this.wait(); //ֻ�ᱻthis.notify()����this.notifyAll()���ѣ������Ǹý���
								//�������̻߳���
					System.out.println(Thread.currentThread().getName() + "hahah");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		String content = null;
		try {
			content = get().getContent(); //get()���ܻ�����(ֱ�������callable�����call()ִ����Ż᲻����)
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return content;
	}

}
