package com.csx;

public class Helper {

	public void handle(int count, char ch) {
		System.out.println(Thread.currentThread().getName() + " count=" + count + " " +  ch + " begin:");
		for(int i = 0; i < count; ++i) {
			slowly();
			System.out.print(ch);
		}
		System.out.println();
		System.out.println(Thread.currentThread().getName() + " count=" + count + " " +  ch + " end!");
	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
