package com.example.api.serviceimpl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.dao.user.PermissionDao;
import com.example.api.entity.user.Permission;
import com.example.api.service.CrudService;
import com.example.api.service.user.PermissionService;

@Service
@Transactional
@com.alibaba.dubbo.config.annotation.Service(version = "0.0.1")
public class PermissionServiceImpl extends CrudService<PermissionDao, Permission> implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getByUserId(int userId) {
        return permissionDao.getByUserId(userId);
    }

    @Override
    public List<Permission> findAllList() {
        return permissionDao.findAllList();
    }
    
}
