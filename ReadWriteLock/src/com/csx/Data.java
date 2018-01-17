package com.csx;

public class Data {

	char [] mBuffer;
	ReadWriteLock mReadWriteLock = new ReadWriteLock();
	public Data(int length) {
		this.mBuffer = new char[length];
		for(int i = 0; i < length; ++i) {
			this.mBuffer[i] = '*';
		}
	}
	
	public char[] read() throws InterruptedException {
		
		try {
			mReadWriteLock.readLock();
			return doRead();
		}  finally {
			mReadWriteLock.readUnlock();
		}
		
	}
	
	public void write(char ch) throws InterruptedException {
		try {
			mReadWriteLock.wirteLock();
			doWrite(ch);
		} finally {
			mReadWriteLock.writeUnlock();
		}
	}

	private void doWrite(char ch) {
		for(int i = 0; i < mBuffer.length; ++i) {
			mBuffer[i] = ch;
		}
		slowly();
	}

	private char[] doRead() {
		char newBuffer[] = new char[mBuffer.length];
		for(int i = 0; i < mBuffer.length; ++i) {
			newBuffer[i] = mBuffer[i];
		}
		slowly();
		return newBuffer;
	}
	
	
	private void slowly() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
