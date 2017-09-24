package com.cc.shiro.service;

import java.util.List;
import java.util.Map;

import com.cc.shiro.pojo.SysOrganization;

public interface OrganizationService {
	public SysOrganization createOrganization(SysOrganization organization);

	public SysOrganization updateOrganization(SysOrganization organization);

	public void deleteOrganization(Long organizationId);

	SysOrganization findOne(Long organizationId);

	List<SysOrganization> findAll();

	List<SysOrganization>  findAllWithExclude(Map<String, String> map);

	void move(Map<String, String> map);
}
