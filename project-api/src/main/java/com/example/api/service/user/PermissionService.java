package com.example.api.service.user;

import java.util.List;

import com.example.api.entity.user.Permission;

public interface PermissionService {

    public List<Permission> getByUserId(int userId);
    
    public List<Permission> findAllList();
}
