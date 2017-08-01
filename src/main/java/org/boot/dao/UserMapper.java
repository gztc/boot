package org.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.boot.model.User;
@Mapper
public interface UserMapper {
	//@Select("select * from t_user")
	public List<User> list();
}
