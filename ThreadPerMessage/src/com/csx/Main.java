package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Host host = new Host();
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
	}

}
