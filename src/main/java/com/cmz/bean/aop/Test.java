package com.cmz.bean.aop;

import java.io.IOException;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cmz.controller.TestController;

public class Test {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("application.xml");
	 	TestController testController = (TestController)context.getBean(TestController.class);
	 	try {
			testController.execute("");
		} catch (IOException e) {
		}finally {
			System.out.println("end");
		}
	}
}
