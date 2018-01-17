package com.csx;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountupThread countupThread =  new CountupThread();
		countupThread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//�رմ�������
		countupThread.shutdown();
		
		try {
			countupThread.join(); //Main�̵߳ȴ����߳�ִ�����ټ���ִ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end!");
	}

}
