package com.example.libraryse.service;

import com.example.libraryse.dao.AdminRoleDAO;
import com.example.libraryse.eneity.AdminMenu;
import com.example.libraryse.eneity.AdminPermission;
import com.example.libraryse.eneity.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;
    public List<AdminRole>  listRolesByUser(String username)
    {
return adminRoleDAO.listRolesByUsername( username);

    }

    public List<AdminRole> listallRoles() {
        return adminRoleDAO.listallRoles();
    }

//    public List<AdminRole> listWithPermsAndMenus() {
//        List<AdminRole> roles = adminRoleDAO.findAll();
//        List<AdminPermission> perms;
//        List<AdminMenu> menus;
//        for (AdminRole role : roles) {
//            perms = adminPermissionService.listPermsByRoleId(role.getId());
//            menus = adminMenuService.getMenusByRoleId(role.getId());
//            role.setPerms(perms);
//            role.setMenus(menus);
//        }
//        return roles;
//    }


}
