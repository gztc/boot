package org.boot.service;

import java.util.List;

import org.boot.model.User;

public interface IUserService {
	
	public List<User> list();
	
	public String findRedis();
	
}
