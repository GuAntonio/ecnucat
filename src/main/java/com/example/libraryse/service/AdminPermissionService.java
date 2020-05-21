package com.example.libraryse.service;

import com.example.libraryse.dao.AdminPermissionDAO;
import com.example.libraryse.dao.AdminRolePermissionDAO;
import com.example.libraryse.eneity.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class AdminPermissionService{

    @Autowired
    UserService userService;
    @Autowired
    AdminPermissionDAO adminPermissionDAO;
    @Autowired
    AdminUserRoleService adminUserRoleService;
        public Set<String> listPermissionURLsByUser(String username) {
            // 从数据库中获取当前用户
             //String username="test";
            User user = userService.getByUserName(username);
            List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                    .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
            Set<String> URLs =new HashSet<>();
            for (Integer b:rids) {
               List<AdminPermission> temp=adminPermissionDAO.listallpermbyRid(b);
                for (AdminPermission ap:temp)
                   URLs.add( ap.getUrl());


            }
//            List<Integer> pids = adminPermissionDAO.listallpermbyRid(b)
//                    .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
//
//            List<AdminPermission> perms = AdminPermissionDAO.findAllById(pids);
//
//            Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

            return URLs;
        }
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }


}
