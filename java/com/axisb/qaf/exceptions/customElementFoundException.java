package com.axisb.qaf.exceptions;

public class customElementFoundException extends Exception {
	public customElementFoundException(String errorMessage) {
		super(errorMessage);
		System.out.println("We will pass Error Messages to Report"+errorMessage);
	}
}
