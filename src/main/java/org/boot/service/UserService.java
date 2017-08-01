package org.boot.service;

import java.util.List;

import org.boot.dao.UserMapper;
import org.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userDao;
	
	//注入集群对象
	@Autowired
	private JedisCluster jedisCluster;

	@Override
	//@Cacheable(value="list")//在事物层测试缓存
	public List<User> list() {
		System.out.println("如果第二次没有输出，说明走了redis缓存，没有执行此方法");
		return userDao.list();
	}
	
	@Override
	public String findRedis() {
		jedisCluster.set("username", "hello redis");
		String value = jedisCluster.get("username");
		return value;
	}
}
