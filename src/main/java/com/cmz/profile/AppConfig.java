package com.cmz.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configurable
@PropertySource("classpath:app.properties")
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean
	@Profile("test")
	public TestBean testBean(){
		TestBean testBean = new TestBean();
		testBean.setName("test"+env.getProperty("name"));
		return testBean;
	}
	
	@Bean
	@Profile("product")
	public TestBean testBean1(){
		TestBean testBean = new TestBean();
		testBean.setName("product"+env.getProperty("name"));
		return testBean;
	}
}
