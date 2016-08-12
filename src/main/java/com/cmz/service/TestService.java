package com.cmz.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
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
	
	@Scheduled(fixedRate=500)
	public void schedule(){
		System.out.println("schedule test!");
	}
}
