package com.example.api.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.example.api.dao.CrudDao;
import com.example.api.entity.user.User;

@Mapper
public interface UserDao extends CrudDao<User> {

}
