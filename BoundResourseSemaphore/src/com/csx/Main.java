package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BoundResource boundResource = new BoundResource(3);
		for(int i = 0; i < 10; ++i) {
			new UserThread(boundResource).start();
		}
	}

}
