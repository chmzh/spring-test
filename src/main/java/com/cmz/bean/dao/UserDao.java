package com.cmz.bean.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.cmz.bean.domain.User;


public interface UserDao {
	public final static String Table = "user";
	public final static String fields = "`id`,`uname`,`pwd`,`enabled`,`qq`";
	
	
	@Insert("INSERT INTO "+Table+"("+fields+") VALUES(0,#{user.uname},#{user.pwd},#{user.enabled},#{user.qq})")
	public int addUser(@Param("user")User user);
	
	@Delete("DELETE FROM "+Table+" WHERE id1=#{id}")
	public int delUser(@Param("id")int id);
}
