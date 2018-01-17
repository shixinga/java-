package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Data data = new Data(10);
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new ReadThread(data).start();
		new WriteThread(data, "abcdefghijklmnopqrstuvwxyz", 12345).start();
		new WriteThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 15545).start();
	}

}
