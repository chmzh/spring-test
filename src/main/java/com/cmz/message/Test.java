package com.cmz.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//资源文件在 classpath:/exceptions_en_GB.properties
		MessageSource resources = new FileSystemXmlApplicationContext("beans.xml"); 
		String message = resources.getMessage("argument.required",new Object [] {"userDao"}, "Required", Locale.UK);
		System.out.println(message);
	}
	
}
