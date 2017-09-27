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
	 * ��ȡ�û�����
	 */
	@Test
	public void selectUserList(){
		List<SysUser> userList = userService.findAll();
		for (SysUser sysUser : userList) {
			System.out.println("�û���:"+sysUser.getUsername()+"�û�id:"+sysUser.getId()+"�û�role:"+sysUser.getRoleIds()+"�û�Ȩ��:"+sysUser.getOrganizationId()+"�û�����:"+sysUser.getPassword());
		}
	}
	/**
	 * �����û�Idɾ���û�
	 */
	/*@Test
	public void deleteUser(){
		userService.deleteUser(new Long(123));
		System.out.println("ɾ���ɹ�");
	}
	*//**
	 * ����û�
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
		System.out.println("��ӳɹ�");
	}
	*//**
	 * �޸��û�
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
		System.out.println("�޸����");
	}
	*//**
	 * �޸��û�����
	 *//*
	@Test
	public void updateUserPassword(){
		userService.changePassword(new Long(1), "admin");
	}
	*//**
	 * ��ȡһ��
	 *//*
	@Test
	public void findUser(){
		SysUser sysUser = userService.findOne(new Long(123));
		System.out.println("�û���:"+sysUser.getUsername()+"�û�id:"+sysUser.getId()+"�û�role:"+sysUser.getRoleIds()+"�û�Ȩ��:"+sysUser.getOrganizationId()+"�û�����:"+sysUser.getPassword());
	}
	*//**
	 * ͨ���û�����ȡ�û�
	 *//*
	@Test
	public void finaUserByUserName(){
		SysUser sysUser = userService.findByUsername("chenchao123");
		System.out.println("�û���:"+sysUser.getUsername()+"�û�id:"+sysUser.getId()+"�û�role:"+sysUser.getRoleIds()+"�û�Ȩ��:"+sysUser.getOrganizationId()+"�û�����:"+sysUser.getPassword());
	}
	*//**
	 * �����û�����ȡ�û�Role
	 *//*
	@Test
	public void findRoles(){
		Set<String> roles = userService.findRoles("chenchao123");
		for (String role : roles) {
			System.out.println(role);
		}
	}
	*//**
	 * ͨ���û�����ȡȨ��
	 *//*
	@Test
	public void findPermissions(){
		Set<String> permissions = userService.findPermissions("chenchao123");
		for (String permission : permissions) {
			System.out.println(permission);
		}
	}*/
}
