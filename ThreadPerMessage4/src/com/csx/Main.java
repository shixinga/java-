package com.csx;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 
 * 和原始版本的差异：
 * 	不用new Thread();
 * 	而是用ScheduledExecutorService接口隐藏new Thread().start();并且按时间运行
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
			//shutdown()后的线程池不能再接收新任务
			//如果接收新任务（即调用executor.execute()）就会抛
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
