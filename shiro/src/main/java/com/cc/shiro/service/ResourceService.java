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
	 * �õ���Դ��Ӧ��Ȩ���ַ���
	 * 
	 * @param resourceIds
	 * @return
	 */
	Set<String> findPermissions(Set<Long> resourceIds);

	/**
	 * �����û�Ȩ�޵õ��˵�
	 * 
	 * @param permissions
	 * @return
	 */
	List<SysResource> findMenus(Set<String> permissions);
}