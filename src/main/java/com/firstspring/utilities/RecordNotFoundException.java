package com.firstspring.utilities;

public class RecordNotFoundException extends Exception {
  @Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "No Record Exists with the given Primary key";
}
}
