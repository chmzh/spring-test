package com.cmz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cmz.base.Controller;
import com.cmz.bean.dao.UserDao;
import com.cmz.bean.domain.User;

@Controller
public class TestController1 {
	
	@Autowired
	private UserDao userDao;
	
	public void t(String a){
		System.out.println(a);
	}
	
	@Transactional
	public void t1(){
		User user = new User();
		user.setUname("abc111");
		user.setPwd("abc");
		user.setEnabled(true);
		user.setQq("dfdfd");
		userDao.addUser(user);
		userDao.delUser(1000);
	}
}
