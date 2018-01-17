package com.csx;

public class FutureData implements IData {
	private boolean mReady = false;
	private IData mReadData;
//	private static Object o = new Object();
	public synchronized  void setData(IData data) {
//		synchronized(o) {
			mReadData = data;
			mReady = true;
//			o.notifyAll(); //唤醒的只是调用o.wait()的线程，而不是这个进程的所有线程！！
			notifyAll(); //唤醒的只是调用this.wait()的线程，而不是这个进程的所有线程！！
			
//		}
//		notify();
	}
	
	@Override
	public synchronized String getContent() {
//		synchronized(o) {
			
			while(!mReady) {
				try {
//					o.wait();//只会被o.notify()或者o.notifyAll()唤醒，而不是该进程
					//的其它线程唤醒
					this.wait(); //只会被this.notify()或者this.notifyAll()唤醒，而不是该进程
								//的其它线程唤醒
					System.out.println(Thread.currentThread().getName() + "hahah");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}
		return mReadData.getContent();
	}

}
