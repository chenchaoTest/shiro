package com.cc.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cc.shiro.pojo.SysRole;
import com.cc.shiro.service.ResourceService;
import com.cc.shiro.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
    private RoleService roleService;

    @Autowired
    private ResourceService resourceService;

    @RequiresPermissions("role:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("roleList", roleService.findAll());
        return "role/list";
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("role", new SysRole());
        model.addAttribute("op", "����");
        return "role/edit";
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(SysRole role, RedirectAttributes redirectAttributes) {
        roleService.createRole(role);
        redirectAttributes.addFlashAttribute("msg", "�����ɹ�");
        return "redirect:/role";
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("role", roleService.findOne(id));
        model.addAttribute("op", "�޸�");
        return "role/edit";
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SysRole role, RedirectAttributes redirectAttributes) {
        roleService.updateRole(role);
        redirectAttributes.addFlashAttribute("msg", "�޸ĳɹ�");
        return "redirect:/role";
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("role", roleService.findOne(id));
        model.addAttribute("op", "ɾ��");
        return "role/edit";
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        roleService.deleteRole(id);
        redirectAttributes.addFlashAttribute("msg", "ɾ���ɹ�");
        return "redirect:/role";
    }

    private void setCommonData(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
    }
}