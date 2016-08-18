package com.cmz.bean.aop.service;

public class DefaultUsageTracked implements IUsageTracked {
	private int count = 0;
	public void increateUseCount(String clazz,String method,String args) {
		count = count + 1;
		System.out.println("类名:["+clazz+"],方法名:["+method+"],参数:["+args+"],调用次数:["+count+"]");
	}

}
