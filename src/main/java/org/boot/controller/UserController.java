package org.boot.controller;

import java.util.List;

import org.boot.model.User;
import org.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/user")
	public User showUser() {
		User u = new User();
		u.setId(1);
		u.setName("张三");
		u.setAge(20);
		return u;
	}
	
	@RequestMapping("/list")
	public List<User> list() {
		return userService.list();
	}
	
	/**
	 * 查询redis集群服务
	 */
	@RequestMapping("find")
	public String findRedis() {
		return userService.findRedis();
	}
	
}
