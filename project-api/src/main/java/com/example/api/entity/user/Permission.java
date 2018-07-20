package com.example.api.entity.user;

import com.example.api.entity.DataEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Permission extends DataEntity {

    // 权限名称
    private String name;

    // 权限描述
    private String descritpion;

    // 授权链接
    private String url;

    // 父节点id
    private int pid;
}
