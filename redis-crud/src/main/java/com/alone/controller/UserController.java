package com.alone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alone.entity.UserBean;
import com.alone.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	/** 
	* RegisterRedis:
	* 用户注册，先存放在redis中，
	* TODO  
	* @author 项羽  
	 * @return 
	*/  
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String RegisterRedis(UserBean userBean){
		System.out.println("UserController.RegisterRedis() start	" + userBean);
		boolean loginRedis = userService.registerRedis(userBean);
		if (!loginRedis) {
			System.out.println("该编号已存在，添加失败");
			return "error";
		}
		System.out.println("添加成功");
		return "index";
	}
	
	/** 
	* DeleteRedis: 
	* @author 项羽 
	* @param userBean
	* @return 修改redis参数 
	*/  
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String DeleteRedis(UserBean userBean){
		System.out.println("UserController.DeleteRedis()");
		boolean deleteRedis = userService.deleteRedis(userBean);
		if (!deleteRedis) {
			System.out.println("删除失败");
			return "error";
		}
		System.out.println("删除成功");
		return "index";
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String UpdateRedis(UserBean userBean){
		System.out.println("UserController.UpdateRedis()");
		boolean deleteRedis = userService.updateRedis(userBean);
		if (!deleteRedis) {
			System.out.println("修改失败");
			return "error";
		}
		System.out.println("修改成功");
		return "index";
	}
}
