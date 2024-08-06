package com.firstspring.service;

import org.springframework.stereotype.Service;

@Service("tservice")
public class DataServiceImpl2 implements DataService {

	@Override
	public String[] getDevelopers() {
		// TODO Auto-generated method stub
		String []team= { "Gagan","Naresh","Lokesh"};
		return team;
		
	}

}
