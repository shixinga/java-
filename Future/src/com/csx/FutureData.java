package com.csx;

public class FutureData implements IData {
	private boolean mReady = false;
	private IData mReadData;
//	private static Object o = new Object();
	public synchronized  void setData(IData data) {
//		synchronized(o) {
			mReadData = data;
			mReady = true;
//			o.notifyAll(); //���ѵ�ֻ�ǵ���o.wait()���̣߳�������������̵������̣߳���
			notifyAll(); //���ѵ�ֻ�ǵ���this.wait()���̣߳�������������̵������̣߳���
			
//		}
//		notify();
	}
	
	@Override
	public synchronized String getContent() {
//		synchronized(o) {
			
			while(!mReady) {
				try {
//					o.wait();//ֻ�ᱻo.notify()����o.notifyAll()���ѣ������Ǹý���
					//�������̻߳���
					this.wait(); //ֻ�ᱻthis.notify()����this.notifyAll()���ѣ������Ǹý���
								//�������̻߳���
					System.out.println(Thread.currentThread().getName() + "hahah");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}
		return mReadData.getContent();
	}

}
