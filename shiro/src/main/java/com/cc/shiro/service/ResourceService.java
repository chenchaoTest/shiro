package com.cc.shiro.service;

import java.util.List;
import java.util.Set;

import com.cc.shiro.pojo.SysResource;

public interface ResourceService {
	public SysResource createResource(SysResource resource);

	public SysResource updateResource(SysResource resource);

	public void deleteResource(Long resourceId);

	SysResource findOne(Long resourceId);

	List<SysResource> findAll();

	/**
	 * 得到资源对应的权限字符串
	 * 
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * 根据用户权限得到菜单
	 * 
	 * @param permissions
	 * @return
	 */
	List<SysResource> findMenus(Set<String> permissions);
}
