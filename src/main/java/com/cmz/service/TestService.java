package com.cmz.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void println(String msg){
		System.out.println(name);
	}
}
