package com.cc.shiro.service;

import java.util.List;
import java.util.Set;

import com.cc.shiro.pojo.SysRole;

public interface RoleService {
    public SysRole createRole(SysRole role);
    public SysRole updateRole(SysRole role);
    public void deleteRole(Long roleId);

    public SysRole findOne(Long roleId);
    public List<SysRole> findAll();

    /**
     * ���ݽ�ɫ��ŵõ���ɫ��ʶ���б�
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * ���ݽ�ɫ��ŵõ�Ȩ���ַ����б�
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
