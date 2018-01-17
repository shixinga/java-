package com.csx;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TsLog {

	private PrintWriter mPw;
	public TsLog(String fileName) {
		try {
			this.mPw = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String s) {
		mPw.println(s);
	}

	public void close() {
		mPw.close();		
	}
}
