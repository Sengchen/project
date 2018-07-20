package com.example.api.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.api.dao.CrudDao;
import com.example.api.entity.user.Permission;

@Mapper
public interface PermissionDao extends CrudDao<Permission> {

    public List<Permission> getByUserId(@Param("userId") int userId);
}
