package com.cc.shiro.service;

import java.util.List;
import java.util.Set;

import com.cc.shiro.pojo.SysUser;
import com.cc.shiro.utils.EasyUIResult;

public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public SysUser createUser(SysUser user);

    public SysUser updateUser(SysUser user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);


    SysUser findOne(Long userId);

    List<SysUser> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public SysUser findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
    
    public EasyUIResult findAll(int page, int rows);
}
