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
		new ClientThread("client11", channel).start();
		new ClientThread("client22", channel).start();
		new ClientThread("client33", channel).start();
		
	}

}
