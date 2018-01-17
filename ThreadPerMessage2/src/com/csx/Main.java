package com.csx;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 
 * 和原始版本的差异：
 * 	不用new Thread();
 * 	而是用ThreadFactory
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
		//Executors.defaultThreadFactory();和上面注释的代码一样
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		Host host = new Host(threadFactory);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
	}

}
