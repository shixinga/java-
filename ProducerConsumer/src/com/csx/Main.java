package com.csx;
/**
 * Main.java是第一种生产者-消费者模式
 * Main2.java是第二种生产者-消费者模式
 * 
 * Main.java用到的java文件如下
 * ProducerThread.java
 * EaterThread.java
 * @author csx
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table table = new Table(6);
		new EaterThread("eater 1", table).start();
		new EaterThread("eater 2", table).start();
		new EaterThread("eater 3", table).start();
		new ProducerThread("maker 1", table).start();
		new ProducerThread("maker 2", table).start();
		new ProducerThread("maker 3", table).start();
	}

}
