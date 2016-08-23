package com.cmz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.annotation.Transactional;

import com.cmz.base.Controller;
import com.cmz.bean.dao.UserDao;
import com.cmz.bean.domain.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

@Controller
public class TestController1 {
	
	@Autowired
	private UserDao userDao;
	
	public void t(String a){
		System.out.println(a);
	}
	
	/**
	 * 当遇到 BadSqlGrammarException 异常时，不会回滚  必须是Throwable的子类
	 */
	@Transactional(noRollbackFor=BadSqlGrammarException.class)
	public void t1(){
		User user = new User();
		user.setUname("abc222");
		user.setPwd("abc");
		user.setEnabled(true);
		user.setQq("dfdfd");
		userDao.addUser(user);
		userDao.delUser(1000);
	}
}
