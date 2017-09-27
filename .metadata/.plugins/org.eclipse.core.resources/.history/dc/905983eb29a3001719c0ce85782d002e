package com.cc.shiro.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.shiro.mapper.SysRoleMapper;
import com.cc.shiro.mapper.SysUserMapper;
import com.cc.shiro.pojo.SysUser;
import com.cc.shiro.pojo.SysUserExample;
import com.cc.shiro.pojo.SysUserExample.Criteria;
import com.cc.shiro.service.RoleService;
import com.cc.shiro.service.UserService;
import com.cc.shiro.utils.EasyUIResult;
import com.cc.shiro.utils.PasswordHelper;
@Service
public class UserServiceImpl implements UserService {

	private PasswordHelper passwordHelper = new PasswordHelper();
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private RoleService roleService;
	
	public SysUser createUser(SysUser user) {
		//¼ÓÃÜÃÜÂë
		passwordHelper.encryptPassword(user);
		int flag = userMapper.insert(user);
		if(flag>0){
			return user;
		}
		return null;
	}

	public SysUser updateUser(SysUser user) {
		int flag = userMapper.updateByPrimaryKey(user);
		if(flag>0){
			return user;
		}
		return null;
	}

	public void deleteUser(Long userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	public void changePassword(Long userId, String newPassword) {
		SysUser user =userMapper.selectByPrimaryKey(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userMapper.updateByPrimaryKey(user);

	}

	public SysUser findOne(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public List<SysUser> findAll() {
		SysUserExample example = new SysUserExample();
		List<SysUser> userList = userMapper.selectByExample(example);
		return userList;
	}

	public SysUser findByUsername(String username) {
		SysUserExample example = new SysUserExample();
		Criteria criteria =  example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<SysUser> userList = userMapper.selectByExample(example);
		if(userList.size()>0){
			return userList.get(0);
		}
		return null;
	}

	public Set<String> findRoles(String username) {
		SysUser user = findByUsername(username);
		if(user == null) {
            return Collections.EMPTY_SET;
        }
		Set<String> roles = roleService.findRoles(Long.parseLong(user.getRoleIds()));
		if(roles.size()>0){
			return roles;
		}
		return null;
	}

	public Set<String> findPermissions(String username) {
		SysUser user =findByUsername(username);
		if(user == null) {
            return Collections.EMPTY_SET;
        }
		String[] r1 = user.getRoleIds().split(",");
		Long[] r2 = new Long[r1.length];
		for (int i = 0; i < r1.length; i++) {
			r2[i] = Long.valueOf(r1[i]);
		}
		Set<String> permissions = roleService.findPermissions(r2);
		if(permissions.size()>0){
			return permissions;
		}
		return null;
	}

	public EasyUIResult findAll(int page, int rows) {
		EasyUIResult result = new EasyUIResult();
		/*PageHelper.startPage(page, rows);
		SysUserExample example = new SysUserExample();
		List<SysUser> userList = userMapper.selectByExample(example);
		EasyUIResult result = new EasyUIResult();
		result.setRows(userList);
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(userList);
		result.setTotal(pageInfo.getTotal());*/
		return result;
	}

}
