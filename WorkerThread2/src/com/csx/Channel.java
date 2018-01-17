package com.csx;
import java.awt.HeadlessException;

public class Channel {

	public static final int MAX_REQUEST = 100;
	private Request []mRequestQueue = new Request[MAX_REQUEST];
	private WorkerThread [] mThreadPool;
	
	private int mCount;//���е�Request���������
	private int mHead;//���е�ͷ
	private int mTail;//���е�β
	
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
			mThreadPool[i].start(); //�����̳߳�������߳�
		}
	}
	
	public synchronized void putRequest(Request request) throws InterruptedException {
		while(mCount >= MAX_REQUEST) {
			wait();
			
		}
		
		mRequestQueue[mTail] = request;
		mTail = (mTail + 1) % MAX_REQUEST;
		mCount++;
		notifyAll();
	}
	
	public synchronized Request handleRequest() throws InterruptedException {
		while(mCount <= 0) {
			wait();
		}
		
		Request request = mRequestQueue[mHead];
		mHead = (mHead + 1) % MAX_REQUEST;
		mCount--;
		notifyAll();
		return request;
	}
	
	public void stopThreads() {
		for(int i = 0; i < mThreadPool.length; ++i) {
			mThreadPool[i].stopThread();
		}
	}
	
}
