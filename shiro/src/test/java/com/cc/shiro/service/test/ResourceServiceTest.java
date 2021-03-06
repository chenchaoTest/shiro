package com.cc.shiro.service.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cc.shiro.pojo.SysResource;
import com.cc.shiro.pojo.SysResource.ResourceType;
import com.cc.shiro.service.ResourceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"}) 
public class ResourceServiceTest {

	@Autowired
	private ResourceService resourceService;
	
	@Test
	public void findAll(){
		List<SysResource> resourceList = resourceService.findAll();
		for (SysResource resource : resourceList) {
			System.out.println("id:"+resource.getId()+"name:"+resource.getName()+"permission"+resource.getPermission());
		}
	}
	
	/*@Test
	public void createResource(){
		SysResource resource = new SysResource();
		resource.setId(new Long(5));
		resource.setName("测试列表");
		resource.setType(ResourceType.menu);
		resource.setUrl("/test");
		resource.setParentId(new Long(1));
		resource.setParentIds("0/1/");
		resource.setPermission("test:*");
		resource.setAvailable(true);
		resourceService.createResource(resource);
	}
	@Test
	public void updateResource(){
		SysResource resource = new SysResource();
		resource.setId(new Long(5));
		resource.setName("测试管理");
		resource.setType(ResourceType.menu);
		resource.setUrl("/test");
		resource.setParentId(new Long(1));
		resource.setParentIds("0/1/");
		resource.setPermission("test:*");
		resource.setAvailable(true);
		resourceService.updateResource(resource);
	}
	@Test
	public void findOne(){
		SysResource resource = resourceService.findOne(new Long(1));
		
		System.out.println("id:"+resource.getId()+"name:"+resource.getName()+"permission"+resource.getPermission());
	}
	@Test
	public void deleteResource(){
		resourceService.deleteResource(new Long(5));
	}
	
	@Test
	public void findPermissions(){
		Set<Long> resourceIds = new HashSet<Long>();
		resourceIds.add(new Long(11));
		resourceIds.add(new Long(22));
		resourceIds.add(new Long(33));
		Set<String> permissions = resourceService.findPermissions(resourceIds);
		for (String p : permissions) {
			System.out.println(p);
		}
	}
	@Test
	public void findMenus(){
		//[resource:*, role:*, user:*, organization:*]
		Set<String> permissions = new HashSet<String>();
		permissions.add("11");
		permissions.add("22");
		permissions.add("33");
		permissions.add("44");
		List<SysResource> resourceList = resourceService.findMenus(permissions);
		for (SysResource resource : resourceList) {
			System.out.println("id:"+resource.getId()+"name:"+resource.getName()+"permission"+resource.getPermission()+"父节点"+resource.getParentId());
		}
	}
	@Test
	public void findSubPermission(){
		List<Long> l = new ArrayList<Long>();
		l.add(new Long(11));
		l.add(new Long(21));
		List<SysResource> resourceList = resourceService.findSubPermission(l);
		for (SysResource resource : resourceList) {
			System.out.println("id:"+resource.getId()+"name:"+resource.getName()+"permission"+resource.getPermission()+"父节点"+resource.getParentId());
		}
	}*/
}
