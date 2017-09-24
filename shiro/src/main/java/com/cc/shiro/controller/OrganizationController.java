package com.cc.shiro.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cc.shiro.pojo.SysOrganization;
import com.cc.shiro.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	@RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "organization/index";
    }
	
	@RequiresPermissions("organization:view")
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String showTree(Model model){
		model.addAttribute("organizationList", organizationService.findAll());
		return "organization/tree";
	}
	
	@RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/maintain", method = RequestMethod.GET)
    public String showMaintainForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("organization", organizationService.findOne(id));
        return "organization/maintain";
    }
	
	@RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        SysOrganization parent = organizationService.findOne(parentId);
        model.addAttribute("parent", parent);
        SysOrganization child = new SysOrganization();
        child.setParentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child", child);
        model.addAttribute("op", "����");
        return "organization/appendChild";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    public String create(SysOrganization organization) {
        organizationService.createOrganization(organization);
        return "redirect:/organization/success";
    }
    
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(SysOrganization organization, RedirectAttributes redirectAttributes) {
        organizationService.updateOrganization(organization);
        redirectAttributes.addFlashAttribute("msg", "�޸ĳɹ�");
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        organizationService.deleteOrganization(id);
        redirectAttributes.addFlashAttribute("msg", "ɾ���ɹ�");
        return "redirect:/organization/success";
    }


    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.GET)
    public String showMoveForm(@PathVariable("sourceId") Long sourceId, Model model) {
    	SysOrganization source = organizationService.findOne(sourceId);
        model.addAttribute("source", source);
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", source.getId().toString());
		map.put("makeSelfAsParentIds", source.makeSelfAsParentIds());
        model.addAttribute("targetList", organizationService.findAllWithExclude(map));
        return "organization/move";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
    public String move(
            @PathVariable("sourceId") Long sourceId,
            @RequestParam("targetId") Long targetId) {
    	SysOrganization source = organizationService.findOne(sourceId);
    	SysOrganization target = organizationService.findOne(targetId);
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("parent_id", target.getId().toString());
		map.put("parent_ids", target.getParentIds());
		map.put("id", source.getId().toString());
		map.put("targetIds", target.makeSelfAsParentIds());
		map.put("sourceIds", source.makeSelfAsParentIds());
        organizationService.move(map);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "organization/success";
    }
}