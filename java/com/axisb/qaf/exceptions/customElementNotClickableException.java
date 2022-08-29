package com.axisb.qaf.exceptions;

@SuppressWarnings("serial")
public class customElementNotClickableException extends Exception {


	public customElementNotClickableException(String errorMessage) {
		super(errorMessage);
		System.out.println("We will pass Error Messages to Report"+errorMessage);
		
	}

}
