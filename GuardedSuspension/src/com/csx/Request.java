package com.csx;

public class Request {

	private String name;

	public Request(String name) {
		super();
		this.name = name;
	}
	
	public String getString() {
		return "[ request " + name + " ]";
	}
}
