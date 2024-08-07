package com.firstspring.utilities;

public class RecordAlreadyExistsException extends Exception {

	 @Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "A Record Already exists with that  primary key";
	}
	 

}
