package com.alone.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.entity.UserBean;
import com.alone.service.IUserService;
import com.alone.utils.RedisBaiseTackes;
@Service
public class UserServiceImpl implements IUserService {

	/*@Autowired
	private IUserMapper userMapper;*/
	@Resource(name="seeUserRedisTakes")
	private RedisBaiseTackes<?, String, ?> seeUserRedisTakes;
	
	
	public boolean registerRedis(UserBean userBean) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl.registerRedis() start 	" + userBean);
		boolean checkKey = seeUserRedisTakes.checkKey(userBean.getUserNumber());
		if (checkKey) {
			System.out.println("该账户已存在");
			return false;
		}
		boolean add = seeUserRedisTakes.add(userBean.getUserNumber(), userBean.getPassword());
		return add;
	}

	@Override
	public Integer registerMysql(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer loginRedis(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer loginMysql(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRedis(UserBean userBean) {
		System.out.println("UserServiceImpl.deleteRedis()");
		boolean delete = seeUserRedisTakes.delete(userBean.getUserNumber());
		if (!delete) {
			System.out.println("删除失败");
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRedis(UserBean userBean) {
		System.out.println("UserServiceImpl.updateRedis()");
		boolean update = seeUserRedisTakes.update(userBean.getUserNumber(), userBean.getOldUserNumber());
		if (!update) {
			System.out.println("修改失败");
			return false;
		}
		return true;
	}

}
