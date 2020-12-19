package com.itcast.controller;

import com.itcast.dao.IRoleDao;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }


    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id",required = true) Integer roleId) throws Exception {
        Role role =roleService.findById(roleId);
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true) Integer roleId,
                                      @RequestParam(name="ids",required = true) Integer[] permissions) throws Exception {

        roleService.addPermissionToRole(roleId,permissions);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/showAdd.do")
    public String showAdd() throws Exception {
        return "role-add";
    }
}
