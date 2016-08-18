package com.cmz.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmz.base.Controller;
import com.cmz.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	public void init(){
		System.out.println("TestController init");
	}

	public void println(String msg){
		testService.println(msg);
	}

	public String execute(String msg) throws IOException{
		System.out.println(msg);
		return "msg";
		//throw new IOException("test");
	}
}
