package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountupThread countupThread =  new CountupThread();
		countupThread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//关闭处理请求
		countupThread.shutdown();
		
		try {
			countupThread.join(); //Main线程等待该线程执行完再继续执行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end!");
	}

}
