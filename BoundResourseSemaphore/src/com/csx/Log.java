package com.csx;

public class Log {

	public static void log(String s) {
		System.out.println(Thread.currentThread().getName() + " : " + s);
	}
}
