package com.csx;

import java.util.concurrent.Executor;

/**
 * 
 * 和原始版本的差异：
 * 	不用new Thread();
 * 	而是用Executor接口隐藏new Thread().start();
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Executor executor = new Executor() {
			
			@Override
			public void execute(final Runnable command) {
				new Thread() {

					@Override
					public void run() {
						command.run();
					}
					
				}.start();
			}
		};
		Host host = new Host(executor);
		host.request(10, 'A');
		host.request(20, 'B');
		host.request(30, 'C');
	}

}
