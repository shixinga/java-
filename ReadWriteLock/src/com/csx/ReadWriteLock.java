package com.csx;

public class ReadWriteLock {

	private int mReadingReaders = 0;
	private int mWritingWriters = 0;
	private int mWaitingWriters = 0;
	private boolean mPreferWriter = true;
	public synchronized void readLock() throws InterruptedException {
		while(mWritingWriters > 0 || (mPreferWriter && mWaitingWriters > 0)) {
			wait();
		}
		
		mReadingReaders++;
	}
	
	public synchronized void readUnlock() {
		mReadingReaders--;
		mPreferWriter = true;
		notifyAll();
	}
	
	public synchronized void wirteLock() throws InterruptedException {
		mWaitingWriters++;
		try {
			
			while(mReadingReaders > 0 || mWritingWriters > 0) {
				wait();
			}
		} finally {
			mWaitingWriters--;
		}
		mWritingWriters++;
		
	}
	
	public synchronized void writeUnlock() {
		mWritingWriters--;
		mPreferWriter = false;
		notifyAll();
	}
}
