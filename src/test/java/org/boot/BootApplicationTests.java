package org.boot;

import java.util.List;

import org.boot.dao.UserMapper;
import org.boot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//junit测试单元
@SpringBootTest//springboot入口测试
public class BootApplicationTests {
	//通过Autowired注入
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testList() {
		List<User> us = userMapper.list();
		for(User u:us) {
			System.out.println(u.getName()+u.getAge());
		}
	}
}
