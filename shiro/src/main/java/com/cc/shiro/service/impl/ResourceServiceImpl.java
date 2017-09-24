package com.cc.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.cc.shiro.mapper.SysResourceMapper;
import com.cc.shiro.pojo.SysResource;
import com.cc.shiro.pojo.SysResourceExample;
import com.cc.shiro.pojo.SysResourceExample.Criteria;
import com.cc.shiro.service.ResourceService;
@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private SysResourceMapper resourceMapper;
	
	public SysResource createResource(SysResource resource) {
		int flag = resourceMapper.insert(resource);
		if(flag>0){
			return resource;
		}
		return null;
	}

	public SysResource updateResource(SysResource resource) {
		int flag = resourceMapper.updateByPrimaryKey(resource);
		if(flag>0){
			return resource;
		}
		return null;
	}

	public void deleteResource(Long resourceId) {
		resourceMapper.deleteByPrimaryKey(resourceId);
	}

	public SysResource findOne(Long resourceId) {
		SysResource resource = resourceMapper.selectByPrimaryKey(resourceId);
		return resource;
	}

	public List<SysResource> findAll() {
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();
		List<SysResource> resourceList = resourceMapper.selectByExample(example);
		if(resourceList.size()>0){
			return resourceList;
		}
		return null;
	}

	public Set<String> findPermissions(Set<Long> resourceIds) {
		Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            SysResource resource = findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
		return permissions;
	}

	public List<SysResource> findMenus(Set<String> permissions) {
		List<SysResource> allResources = findAll();
        List<SysResource> menus = new ArrayList<SysResource>();
        for(SysResource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(resource.getType() != SysResource.ResourceType.menu) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
		return menus;
	}
	
	private boolean hasPermission(Set<String> permissions, SysResource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

}
