package com.csx;

import java.util.concurrent.Executor;

/**
 * 
 * ��ԭʼ�汾�Ĳ��죺
 * 	����new Thread();
 * 	������Executor�ӿ�����new Thread().start();
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
