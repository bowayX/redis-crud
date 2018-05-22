package com.alone.service;

import com.alone.entity.UserBean;

public interface IUserService {

	public boolean registerRedis(UserBean userBean);
	public Integer registerMysql(UserBean userBean);
	public Integer loginRedis(UserBean userBean);
	public Integer loginMysql(UserBean userBean);
	//删除测试
	public boolean deleteRedis(UserBean userBean);
	//修改测试
	public boolean updateRedis(UserBean userBean);
}
