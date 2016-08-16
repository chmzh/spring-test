package com.cmz.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//context.getEnvironment().setActiveProfiles("test");
		context.getEnvironment().setActiveProfiles("product");
		context.register(AppConfig.class);
		context.refresh();
		TestBean testBean = context.getBean(TestBean.class);
		System.out.println(testBean.getName());
	}
}
