package com.csx;

public class Request {

	public String mName;
	public int mNo;
	public Request(String name, int No) {
		this.mName = name;
		this.mNo = No;
	}
	
	
	public void execute() {
		System.out.println(Thread.currentThread().getName() + " 处理来自 " + mName + " 请求的 第" + mNo + " 个请求");
	}
}
