package com.cc.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.shiro.mapper.SysRoleMapper;
import com.cc.shiro.pojo.SysRole;
import com.cc.shiro.pojo.SysRoleExample;
import com.cc.shiro.service.ResourceService;
import com.cc.shiro.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private SysRoleMapper roleMapper;
	
	@Autowired
	private ResourceService resourceService;

	public SysRole createRole(SysRole role) {
		roleMapper.insert(role);
		return role;
	}

	public SysRole updateRole(SysRole role) {
		roleMapper.updateByPrimaryKey(role);
		return role;
	}

	public void deleteRole(Long roleId) {
		roleMapper.deleteByPrimaryKey(roleId);
	}

	public SysRole findOne(Long roleId) {
		
		return roleMapper.selectByPrimaryKey(roleId);
	}

	public List<SysRole> findAll() {
		SysRoleExample example = new SysRoleExample();
		List<SysRole> roles = roleMapper.selectByExample(example);
		return roles;
	}

	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            SysRole role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
	}

	public Set<String> findPermissions(Long[] roleIds) {
		Set<Long> resourceIds = new HashSet<Long>();
		for (Long roleId : roleIds) {
			SysRole role = findOne(roleId);
			if (role != null) {
				List<Long> resources = new ArrayList<Long>();
				String[] r1 = role.getResourceIds().split(",");
				for (int i = 0; i < r1.length; i++) {
					resources.add(Long.parseLong(r1[i]));
				}
				resourceIds.addAll(resources);
			}
		}
		Set<String> permissions = resourceService.findPermissions(resourceIds);
		if(permissions.size()>0){
			return permissions;
		}
		return null;
	}

}
