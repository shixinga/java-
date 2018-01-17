package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "r1", 1111l).start();
		new ClientThread(new RequestQueue(), "r2", 2222l).start();
		new ServerThread(requestQueue, "s1", 3333l).start();
		new ServerThread(requestQueue, "s2", 4444l).start();
		
//		final Main m = new Main();
//		final Main m2 = new Main();
//		final Thread t1 = new Thread() {
//			@Override
//			public void run() {
//				synchronized(m) {
//					try {
//						m.wait();
//						System.out.println("qqqqq");
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				
//				try {
//					Thread.sleep(8000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				while(true) {
//					System.out.println("ff");
//					try {
//						Thread.sleep(8000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		};
//		t1.start();
//		new Thread() {
//			
//			@Override
//			public void run() {
//				synchronized(m2) {
//					try {
//						Thread.sleep(1000);
//						m2.notifyAll();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(t1.isInterrupted());
//				t1.interrupt();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("after:" + t1.isInterrupted());
//			}
//			
//		}.start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		requestQueue.putRequest(new Request("fufufuuf"));
//		requestQueue.notifyAll();
	}

}
