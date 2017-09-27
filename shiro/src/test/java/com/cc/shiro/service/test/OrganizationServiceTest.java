package com.cc.shiro.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cc.shiro.pojo.SysOrganization;
import com.cc.shiro.service.OrganizationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"}) 
public class OrganizationServiceTest {

	@Autowired
	private OrganizationService organizationService;
	
	@Test
	public void findAll(){
		List<SysOrganization> oList = organizationService.findAll();
		for (SysOrganization o : oList) {
			System.out.println("name:"+o.getName()+"Parentid:"+o.getParentId());
		}
	}
	
	/*@Test
	public void createOrganization(){
		SysOrganization o = new SysOrganization();
		o.setId(new Long(5));
		o.setName("总公司3");
		o.setParentId(new Long(1));
		o.setParentIds("0/1/");
		o.setAvailable(true);
		organizationService.createOrganization(o);
	}
	
	@Test
	public void findOne(){
		SysOrganization o = organizationService.findOne(new Long(5));
		System.out.println("name:"+o.getName()+"Parentid:"+o.getParentId());
	}
	@Test
	public void updateOrganization(){
		SysOrganization o = new SysOrganization();
		o.setId(new Long(5));
		o.setName("总公司5");
		o.setParentId(new Long(1));
		o.setParentIds("0/1/");
		o.setAvailable(true);
		organizationService.updateOrganization(o);
	}
	
	@Test
	public void deleteOrganization(){
		organizationService.deleteOrganization(new Long(5));
	}
	
	@Test
	public void findAllWithExclude(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "3");
		map.put("makeSelfAsParentIds", "13/");
		List<SysOrganization> oList =  organizationService.findAllWithExclude(map);
		System.out.println(oList.size());
	}
	
	@Test
	public void move(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("parent_id", "22");
		map.put("parent_ids", "0/1/2/3/4/5/");
		map.put("id", "4");
		map.put("targetIds", "0/1/2/3/4/5/");
		map.put("sourceIds", "6/7/8/");
		organizationService.move(map);
	}*/
}
