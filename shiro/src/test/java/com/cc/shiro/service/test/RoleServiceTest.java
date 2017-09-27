package com.cc.shiro.service.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cc.shiro.pojo.SysRole;
import com.cc.shiro.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"}) 
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 获取全部记录
	 */
	@Test
	public void findAll(){
		List<SysRole> roleList = roleService.findAll();
		for (SysRole role : roleList) {
			System.out.println("roleId:"+role.getId()+"role:"+role.getRole()+"description:"+role.getDescription()+"resources_ids:"+role.getResourceIds());
		}
	}
	
	/**
	 * 添加Role
	 */
	/*@Test
	public void createRole(){
		SysRole role = new SysRole();
		role.setId(new Long(123));
		role.setRole("test");
		role.setDescription("测试管理员");
		role.setResourceIds("21,31,41");
		role.setAvailable(true);
		roleService.createRole(role);
		System.out.println("添加成功");
	}
	*//**
	 * 修改role
	 *//*
	@Test
	public void updateRole(){
		SysRole role = new SysRole();
		role.setId(new Long(123));
		role.setRole("test123");
		role.setDescription("测试超级管理员");
		role.setResourceIds("21");
		role.setAvailable(true);
		roleService.updateRole(role);
	}
	
	@Test
	public void deleteRole(){
		roleService.deleteRole(new Long(123));
	}
	@Test
	public void findOne(){
		SysRole role = roleService.findOne(new Long(123));
		System.out.println("roleId:"+role.getId()+"role:"+role.getRole()+"description:"+role.getDescription()+"resources_ids:"+role.getResourceIds());
	}
	@Test
	public void findRoles(){
		Set<String> role = roleService.findRoles(new Long("123"),new Long("1"));
		for (String r : role) {
			System.out.println(r);
		}
	}
	@Test
	public void findPermissions(){
		Long[] roleIds = {new Long(1),new Long(123)};
		Set<String> Permissions = roleService.findPermissions(roleIds);
		for (String permission : Permissions) {
			System.out.println(permission);
		}
	}*/
}
