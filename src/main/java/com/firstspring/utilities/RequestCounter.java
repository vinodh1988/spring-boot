package com.firstspring.utilities;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestCounter {
	
	private Integer Counter;

	public Integer getCounter() {
		return Counter;
	}

	public void setCounter() {
		Counter++;
	}
	
	

}
