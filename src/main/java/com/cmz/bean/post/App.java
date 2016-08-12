package com.cmz.bean.post;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cmz.controller.TestController;



/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("application.xml");
    	TestController testController = (TestController)context.getBean(TestController.class);
    	testController.println("");
    }
}
