package com.cc.shiro.service.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cc.shiro.pojo.SysUser;
import com.cc.shiro.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"}) 
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取用户集合
	 */
	@Test
	public void selectUserList(){
		List<SysUser> userList = userService.findAll();
		for (SysUser sysUser : userList) {
			System.out.println("用户名:"+sysUser.getUsername()+"用户id:"+sysUser.getId()+"用户role:"+sysUser.getRoleIds()+"用户权限:"+sysUser.getOrganizationId()+"用户密码:"+sysUser.getPassword());
		}
	}
	/**
	 * 根据用户Id删除用户
	 */
	/*@Test
	public void deleteUser(){
		userService.deleteUser(new Long(123));
		System.out.println("删除成功");
	}
	*//**
	 * 添加用户
	 *//*
	@Test
	public void insertUser(){
		SysUser user = new SysUser();
		user.setId(new Long(123));
		user.setLocked(true);
		user.setSalt("chenchao");
		user.setPassword("123456");
		user.setUsername("chenchao");
		user.setRoleIds("1");
		user.setOrganizationId(new Long(1));
		userService.createUser(user);
		System.out.println("添加成功");
	}
	*//**
	 * 修改用户
	 *//*
	@Test
	public void updateUser(){
		SysUser user = new SysUser();
		user.setId(new Long(123));
		user.setLocked(true);
		user.setSalt("chenchao123");
		user.setPassword("123456");
		user.setUsername("chenchao123");
		user.setRoleIds("1");
		user.setOrganizationId(new Long(1));
		userService.updateUser(user);
		System.out.println("修改完成");
	}
	*//**
	 * 修改用户密码
	 *//*
	@Test
	public void updateUserPassword(){
		userService.changePassword(new Long(1), "admin");
	}
	*//**
	 * 获取一个
	 *//*
	@Test
	public void findUser(){
		SysUser sysUser = userService.findOne(new Long(123));
		System.out.println("用户名:"+sysUser.getUsername()+"用户id:"+sysUser.getId()+"用户role:"+sysUser.getRoleIds()+"用户权限:"+sysUser.getOrganizationId()+"用户密码:"+sysUser.getPassword());
	}
	*//**
	 * 通过用户名获取用户
	 *//*
	@Test
	public void finaUserByUserName(){
		SysUser sysUser = userService.findByUsername("chenchao123");
		System.out.println("用户名:"+sysUser.getUsername()+"用户id:"+sysUser.getId()+"用户role:"+sysUser.getRoleIds()+"用户权限:"+sysUser.getOrganizationId()+"用户密码:"+sysUser.getPassword());
	}
	*//**
	 * 根据用户名获取用户Role
	 *//*
	@Test
	public void findRoles(){
		Set<String> roles = userService.findRoles("chenchao123");
		for (String role : roles) {
			System.out.println(role);
		}
	}
	*//**
	 * 通过用户名获取权限
	 *//*
	@Test
	public void findPermissions(){
		Set<String> permissions = userService.findPermissions("chenchao123");
		for (String permission : permissions) {
			System.out.println(permission);
		}
	}*/
}
