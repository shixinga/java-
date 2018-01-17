package com.csx;

import java.util.concurrent.TimeoutException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data data = new Data("haha.txt", "empty");
		new ChangeThread("change thread", data).start();
		new AutoSaveThread("save thread", data).start();
		
		
//		final Host host = new Host(5000);
//		new Thread() {
//			public void run() {
//				System.out.println("begin!!!");
//				try {
//					host.execute();
//				} catch (TimeoutException | InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}.start();
//		
//		try {
//			Thread.sleep(1000);
//			host.setExecutable(true);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
