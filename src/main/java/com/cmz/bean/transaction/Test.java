package com.cmz.bean.transaction;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cmz.controller.TestController1;

public class Test {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("application2.xml");
		TestController1 testController1 = context.getBean(TestController1.class);
		
		testController1.t1();
	}
}
