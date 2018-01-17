package com.csx;

import java.util.concurrent.Exchanger;
/**
 * Main.java是第一种生产者-消费者模式
 * Main2.java是第二种生产者-消费者模式
 * 
 * Main2.java用到的java文件如下：
 * ProThread.java
 * ConThread.java
 * @author csx
 *
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exchanger<char[]> exchanger = new Exchanger<>();
		char[] buffer1 = new char[12];
		new ProThread("producer thread ", exchanger, buffer1 ).start();
		char[] buffer2 = new char[12];
		new ConThread("consumer thread ", exchanger, buffer2 ).start();
	}

}
