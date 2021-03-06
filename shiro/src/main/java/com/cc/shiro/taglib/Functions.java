package com.cc.shiro.taglib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.cc.shiro.cache.SpringUtils;
import com.cc.shiro.pojo.SysOrganization;
import com.cc.shiro.pojo.SysResource;
import com.cc.shiro.pojo.SysRole;
import com.cc.shiro.service.OrganizationService;
import com.cc.shiro.service.ResourceService;
import com.cc.shiro.service.RoleService;
public class Functions {
	public static boolean in(Iterable iterable, Object element) {
		if (iterable == null) {
			return false;
		}
		return CollectionUtils.contains(iterable.iterator(), element);
	}
	
	public static boolean in(String rIds, Object element) {
		if (rIds == null) {
			return false;
		}
		List<Long> resourceIds = new ArrayList<Long>();
		String[] r1 = rIds.split(",");
		Long[] roleIds = new Long[r1.length];
		for (int i = 0; i < r1.length; i++) {
			roleIds[i] = Long.valueOf(r1[i]);
		}
		resourceIds = Arrays.asList(roleIds);
		return CollectionUtils.contains(resourceIds.iterator(), element);
	}

	public static String organizationName(Long organizationId) {
		SysOrganization organization = getOrganizationService().findOne(
				organizationId);
		if (organization == null) {
			return "";
		}
		return organization.getName();
	}

	public static String organizationNames(Collection<Long> organizationIds) {
		if (CollectionUtils.isEmpty(organizationIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Long organizationId : organizationIds) {
			SysOrganization organization = getOrganizationService().findOne(
					organizationId);
			if (organization == null) {
				return "";
			}
			s.append(organization.getName());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	public static String roleName(Long roleId) {
		SysRole role = getRoleService().findOne(roleId);
		if (role == null) {
			return "";
		}
		return role.getDescription();
	}

	public static String roleNames(Collection<Long> roleIds) {
		if (CollectionUtils.isEmpty(roleIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Long roleId : roleIds) {
			SysRole role = getRoleService().findOne(roleId);
			if (role == null) {
				return "";
			}
			s.append(role.getDescription());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}
	
	public static String roleNames(String rs) {
		if(rs.equals("")||rs==null){
			return "";
		}
		String[] r1 = rs.split(",");
		Long[] roleIds = new Long[r1.length];
		for (int i = 0; i < r1.length; i++) {
			roleIds[i] = Long.valueOf(r1[i]);
		}
		StringBuilder s = new StringBuilder();
		for (Long roleId : roleIds) {
			SysRole role = getRoleService().findOne(roleId);
			if (role == null) {
				return "";
			}
			s.append(role.getDescription());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	public static String resourceName(Long resourceId) {
		SysResource resource = getResourceService().findOne(resourceId);
		if (resource == null) {
			return "";
		}
		return resource.getName();
	}

	public static String resourceNames(Collection<Long> resourceIds) {
		if (CollectionUtils.isEmpty(resourceIds)) {
			return "";
		}

		StringBuilder s = new StringBuilder();
		for (Long resourceId : resourceIds) {
			SysResource resource = getResourceService().findOne(resourceId);
			if (resource == null) {
				return "";
			}
			s.append(resource.getName());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}
	
	public static String resourceNames(String rIds) {
		if(rIds.equals("")||rIds==null){
			return "";
		}
		String[] r1 = rIds.split(",");
		Long[] resourceIds = new Long[r1.length];
		for (int i = 0; i < r1.length; i++) {
			resourceIds[i] = Long.valueOf(r1[i]);
		}

		StringBuilder s = new StringBuilder();
		for (Long resourceId : resourceIds) {
			SysResource resource = getResourceService().findOne(resourceId);
			if (resource == null) {
				return "";
			}
			s.append(resource.getName());
			s.append(",");
		}

		if (s.length() > 0) {
			s.deleteCharAt(s.length() - 1);
		}

		return s.toString();
	}

	private static OrganizationService organizationService;
	private static RoleService roleService;
	private static ResourceService resourceService;

	public static OrganizationService getOrganizationService() {
		if (organizationService == null) {
			organizationService = SpringUtils
					.getBean(OrganizationService.class);
		}
		return organizationService;
	}

	public static RoleService getRoleService() {
		if (roleService == null) {
			roleService = SpringUtils.getBean(RoleService.class);
		}
		return roleService;
	}

	public static ResourceService getResourceService() {
		if (resourceService == null) {
			resourceService = SpringUtils.getBean(ResourceService.class);
		}
		return resourceService;
	}
}
