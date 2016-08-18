package com.cmz.bean.aop;

import java.io.IOException;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cmz.controller.TestController;
import com.cmz.controller.TestController1;

public class Test {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("application.xml");
		TestController1 testController1 = (TestController1)context.getBean(TestController1.class);
		testController1.t("abc");
		testController1.t("abc");
		testController1.t("abc");
	 	TestController testController = (TestController)context.getBean(TestController.class);
	 	try {
			testController.execute("hi");
			testController.println("hi");
		} catch (IOException e) {
		}finally {
			System.out.println("end");
		}
	}
}
