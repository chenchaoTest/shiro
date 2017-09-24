package com.cc.shiro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.shiro.mapper.SysOrganizationMapper;
import com.cc.shiro.pojo.SysOrganization;
import com.cc.shiro.pojo.SysOrganizationExample;
import com.cc.shiro.service.OrganizationService;
@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private SysOrganizationMapper organizationMapper;
	
	public SysOrganization createOrganization(SysOrganization organization) {
		int flag = organizationMapper.insert(organization);
		if(flag > 0){
			return organization;
		}
		return null;
	}

	public SysOrganization updateOrganization(SysOrganization organization) {
		int flag = organizationMapper.updateByPrimaryKeySelective(organization);
		if(flag > 0){
			return organization;
		}
		return null;
	}

	public void deleteOrganization(Long organizationId) {
		organizationMapper.deleteByPrimaryKey(organizationId);
	}

	public SysOrganization findOne(Long organizationId) {
		SysOrganization organization = organizationMapper.selectByPrimaryKey(organizationId);
		return organization;
	}

	public List<SysOrganization> findAll() {
		SysOrganizationExample example = new SysOrganizationExample();
		List<SysOrganization>  organizationList = organizationMapper.selectByExample(example);
		if(organizationList.size()>0){
			return organizationList;
		}
		return null;
	}

	public List<SysOrganization>  findAllWithExclude(Map<String, String> map) {
		return organizationMapper.findAllWithExclude(map);
	}

	public void move(Map<String, String> map) {
		organizationMapper.moveSourceSql(map);
		organizationMapper.moveSourceDescendantsSql(map);
	}

}
