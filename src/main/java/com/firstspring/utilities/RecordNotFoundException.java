package com.firstspring.utilities;

public class RecordNotFoundException extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "No Record Exists with the given Primary key";
}
}
