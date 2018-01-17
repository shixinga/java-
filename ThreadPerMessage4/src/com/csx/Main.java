package com.csx;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 
 * ��ԭʼ�汾�Ĳ��죺
 * 	����new Thread();
 * 	������ScheduledExecutorService�ӿ�����new Thread().start();���Ұ�ʱ������
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		Host host = new Host(executor);
		try {
			
			host.request(10, 'A');
			host.request(20, 'B');
			host.request(30, 'C');
		} finally {
			System.out.println("main end......");
			executor.shutdown();
			//shutdown()����̳߳ز����ٽ���������
			//������������񣨼�����executor.execute()���ͻ���
			// java.util.concurrent.RejectedExecutionException
			/*executor.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("aaaa");
				}
			});*/
		}
	}

}
