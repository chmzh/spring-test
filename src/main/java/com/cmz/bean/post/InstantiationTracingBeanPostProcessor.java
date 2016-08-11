package com.cmz.bean.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 该方法在初始化之前调用 在 @PostConstruct 方法之前
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created before : " + bean.toString());
		return bean;
	}
	/**
	 * 该方法在初始化之后调用 在 @PostConstruct 方法之后
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}
}
