package com.csx;
import java.awt.HeadlessException;

public class Channel {

	public static final int MAX_REQUEST = 100;
	private Request []mRequestQueue = new Request[MAX_REQUEST];
	private WorkerThread [] mThreadPool;
	
	private int mCount;//队列的Request对象的数量
	private int mHead;//队列的头
	private int mTail;//队列的尾
	
	public Channel(int threadCounts) {
		mThreadPool = new WorkerThread[threadCounts];
		for(int i = 0; i < threadCounts; ++i) {
			mThreadPool[i] = new WorkerThread("worker--" + i, this);
		}
		mCount = 0;
		mHead = 0;
		mTail = 0;
	}
	
	
	public void startWorkerThreads() {
		for(int i = 0; i < mThreadPool.length; ++i) {
			mThreadPool[i].start(); //开启线程池里面的线程
		}
	}
	
	public synchronized void putRequest(Request request) {
		while(mCount >= MAX_REQUEST) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		mRequestQueue[mTail] = request;
		mTail = (mTail + 1) % MAX_REQUEST;
		mCount++;
		notifyAll();
	}
	
	public synchronized Request handleRequest() {
		while(mCount <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Request request = mRequestQueue[mHead];
		mHead = (mHead + 1) % MAX_REQUEST;
		mCount--;
		notifyAll();
		return request;
	}
	
}
