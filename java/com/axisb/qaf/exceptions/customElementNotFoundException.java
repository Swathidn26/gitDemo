package com.axisb.qaf.exceptions;

@SuppressWarnings("serial")
public class customElementNotFoundException extends Exception{

	public customElementNotFoundException(String errorMessage) {
		super(errorMessage);
		System.out.println("We will pass Error Messages to Report"+errorMessage);
	}

}
