package com.csx;

public class RealData implements IData {

	private String mContent;
	
	
	
	public RealData(int count, char ch) {
		char [] buffer = new char[count];
		for(int i = 0; i < count; ++i) {
			buffer[i] = ch;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		mContent = new String(buffer);
	}



	@Override
	public String getContent() {
		
		return mContent;
	}

}
