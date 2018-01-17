package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ClientThread("aa").start();
		new ClientThread("BB").start();
		new ClientThread("cc").start();
	}

}
