package com.csx;
/**
 * ��Producer-Consumer����һ����ֻ�����ֻ���
 * 
 * @author csx
 *
 */
public class Main {

	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkerThreads();
		ClientThread c1 = new ClientThread("client11", channel);
		ClientThread c2 = new ClientThread("client22", channel);
		ClientThread c3 = new ClientThread("client33", channel);
		
		c1.start();
		c2.start();
		c3.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		channel.stopThreads();
		c1.stopThread();
		c2.stopThread();
		c3.stopThread();
		
	}

}
