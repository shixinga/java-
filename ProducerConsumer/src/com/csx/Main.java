package com.csx;
/**
 * Main.java�ǵ�һ��������-������ģʽ
 * Main2.java�ǵڶ���������-������ģʽ
 * 
 * Main.java�õ���java�ļ�����
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
