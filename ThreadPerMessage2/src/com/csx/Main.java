package com.csx;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 
 * ��ԭʼ�汾�Ĳ��죺
 * 	����new Thread();
 * 	������ThreadFactory
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ThreadFactory threadFactory = new ThreadFactory() {
//			
//			@Override
//			public Thread newThread(Runnable r) {
//				return new Thread(r);
//			}
//		};
		//Executors.defaultThreadFactory();������ע�͵Ĵ���һ��
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		Host host = new Host(threadFactory);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
	}

}
