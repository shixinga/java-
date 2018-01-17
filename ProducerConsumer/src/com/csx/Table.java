package com.csx;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

public class Table {

//	private String[] mBuffer;
	int mTotal;
	private int mHead;
	private int mTail;
	private int mCount;
//	LinkedList<String> mCakes;
	ArrayBlockingQueue<String> mArrayBlockingQueue;
	public Table(int count) {
//		this.mBuffer = new String[count];
		
		
//		this.mHead = 0;
//		this.mTail = 0;
//		this.mCount = 0;
//		this.mTotal = count;
//		mCakes = new LinkedList<>();
		mArrayBlockingQueue = new ArrayBlockingQueue<>(count);
	}
	
	public void put(String cake) throws Exception {
		System.out.println(Thread.currentThread().getName() + " put " + cake + "... count=" + mArrayBlockingQueue.size());
		mArrayBlockingQueue.put(cake);
//		while(mCount >= mTotal) {
//			wait();
//		}
//		
//		mCount++;
//		mCakes.add(cake);
//		System.out.println(Thread.currentThread().getName() + " put " + cake + "... count=" + mCount);
//		notifyAll();
		
		
//		while(mCount >= mBuffer.length) {
//			wait();
//		}
//		mCount++;
//		mBuffer[mTail] = cake;
//		mTail = (mTail + 1) % mBuffer.length;
//		System.out.println(Thread.currentThread().getName() + " put " + cake + "... count=" + mCount);
//		notifyAll();
	}
	
	public void take() throws Exception {
		
		String cake = mArrayBlockingQueue.take();
		System.out.println(Thread.currentThread().getName() + " eat " + cake + "... count=" + mArrayBlockingQueue.size());
//		while(mCount <= 0) {
//			wait();
//		}
//		
//		mCount--;
//		String cake = mCakes.remove();
//		System.out.println(Thread.currentThread().getName() + " eat " + cake + "... count=" + mCount);
//		notifyAll();
		
		
//		while(mCount <= 0) {
//			wait();
//		}
//		
//		mCount--;
//		String cake = mBuffer[mHead];
//		System.out.println(Thread.currentThread().getName() + " eat " + cake + "... count=" + mCount);
//		mHead = (mHead + 1) % mBuffer.length;
//		notifyAll();
	}
	
}
