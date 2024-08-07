package com.firstspring.utilities;

public class RecordAlreadyExistsException extends Exception {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "A Record Already exists with that  primary key";
	}
	 

}
