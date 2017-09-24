package com.cc.shiro.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cc.shiro.annotation.CurrentUser;
import com.cc.shiro.constants.Constants;
import com.cc.shiro.pojo.SysResource;
import com.cc.shiro.pojo.SysUser;
import com.cc.shiro.service.ResourceService;
import com.cc.shiro.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserService userService;
	
	
	//@CurrentUser SysUser loginUser
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		SysUser loginUser =(SysUser) request.getAttribute(Constants.CURRENT_USER);
		Set<String> permissions = userService.findPermissions(loginUser
				.getUsername());
		List<SysResource> menus = resourceService.findMenus(permissions);
		model.addAttribute("menus", menus);
		return "index";
	}
	@RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
