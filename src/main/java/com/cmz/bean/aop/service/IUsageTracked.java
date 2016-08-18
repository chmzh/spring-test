package com.cmz.bean.aop.service;

public interface IUsageTracked {
	public void increateUseCount(String clazz,String method,String args);
}
