package com.cogent.empms.exceptions;

public class InvalidEmpIdException extends Exception {
	
	
	public InvalidEmpIdException(String msg) {
		// msg : a message for exception 
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();// the message which we provided ===> we can get it via getMessage method.
		
	}

}
