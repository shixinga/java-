package com.csx;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log {

	private static ThreadLocal<TsLog> sThreadLocal = new ThreadLocal<>();
	
	
	public static void printLn(String s) {
		getLog().println(s);
	}
	
	public static void close() {
		getLog().close();
	}
	
	public static TsLog getLog() {
		TsLog log = sThreadLocal.get();
		if (log == null) {
			log = new TsLog(Thread.currentThread().getName() + "-log.txt");
			sThreadLocal.set(log);
		}
		return log;
	}
	
}
