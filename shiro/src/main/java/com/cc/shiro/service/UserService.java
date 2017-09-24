package com.cc.shiro.service;

import java.util.List;
import java.util.Set;

import com.cc.shiro.pojo.SysUser;

public interface UserService {

    /**
     * �����û�
     * @param user
     */
    public SysUser createUser(SysUser user);

    public SysUser updateUser(SysUser user);

    public void deleteUser(Long userId);

    /**
     * �޸�����
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);


    SysUser findOne(Long userId);

    List<SysUser> findAll();

    /**
     * �����û��������û�
     * @param username
     * @return
     */
    public SysUser findByUsername(String username);

    /**
     * �����û����������ɫ
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * �����û���������Ȩ��
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
}
