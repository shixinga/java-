package com.csx;

import java.io.FileWriter;
import java.io.IOException;

public class Data {

	private String mFilename;
	private String mContent;
	private boolean mChanged;
	public Data(String filename, String content) {
		super();
		this.mFilename = filename;
		this.mContent = content;
		this.mChanged = true;
	}
	
	
	public synchronized void changeContent(String newContent) {
		mContent = newContent;
		mChanged = true;
	}
	
	public synchronized void save() throws IOException {
		if(!mChanged) {
			return;
		}
		
		doSave();
		mChanged = false;
	}


	private void doSave() throws IOException {
		System.out.println(Thread.currentThread().getName() + " save content:" + mContent);
		FileWriter fw = new FileWriter(mFilename);
		fw.write(mContent);
		fw.close();
	}
	
}
