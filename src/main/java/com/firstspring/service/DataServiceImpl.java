package com.firstspring.service;

import org.springframework.stereotype.Service;

@Service("dservice")
public class DataServiceImpl implements DataService {
	
	{
		//executes automatically if an object is instantiated
		System.out.println("DATA SERVICE IMPLEMENTATION IS INSTANTIATED");
	}

	@Override
	public String[] getDevelopers() {
		// TODO Auto-generated method stub
		String names[]= {"Raju","Lokesh","Arjun","Rakesh","Joseph","Anthony","Rajeev"};
		return names;
	}

}
