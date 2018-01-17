package com.csx;

/**
 *
 * 运用了concurrent.Future和FutureTask接口
 * @author sunray
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Host host = new Host();
		final IData data1 = host.handleRequest(30, 'a');
		final IData data2 = host.handleRequest(20, 'b');
		final IData data3 = host.handleRequest(10, 'c');
		
//		doSomething();
		new Thread() {
			@Override
			public void run() {
				System.out.println(data1.getContent());
			}
			
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(data2.getContent());
			}
			
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(data3.getContent());
			}
		}.start();
		
		
	}

	private static void doSomething() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
