package com.csx.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {

	//参数true：每个线程获取所得的锁是公平的
	ReentrantReadWriteLock mReentrantReadWriteLock = new ReentrantReadWriteLock(true /*fair*/);
	Lock mReadLock = mReentrantReadWriteLock.readLock();
	Lock mWriteLock = mReentrantReadWriteLock.writeLock();
	char [] mBuffer;
	public Data(int length) {
		this.mBuffer = new char[length];
		for(int i = 0; i < length; ++i) {
			this.mBuffer[i] = '*';
		}
	}
	
	public char[] read() throws InterruptedException {
		
		try {
			mReadLock.lock();
			return doRead();
		}  finally {
			mReadLock.unlock();
		}
		
	}
	
	public void write(char ch) throws InterruptedException {
		try {
			mWriteLock.lock();
			doWrite(ch);
		} finally {
			mWriteLock.unlock();
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
