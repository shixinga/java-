package com.csx;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

	private static BlockingQueue<Request> mQueue = new LinkedBlockingQueue<Request>();
	
	public Request getRequest() {
		
		Request request = null;
		try {
			request = mQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return request;
		
/*		synchronized(this) {
			
			while(mQueue.peek() == null) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			return mQueue.remove();
		}
*/	}
	
	public void putRequest(Request request) {
		try {
			mQueue.put(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			/*synchronized(this) {
				
				System.out.println(Thread.currentThread().getName() + " request " + request.getString());
				mQueue.offer(request);
				notifyAll();
			}*/
	}
}
