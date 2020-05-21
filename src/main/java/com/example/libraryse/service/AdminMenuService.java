package com.example.libraryse.service;

import com.example.libraryse.dao.AdminMenuDAO;
import com.example.libraryse.eneity.AdminMenu;
import com.example.libraryse.eneity.AdminRoleMenu;
import com.example.libraryse.eneity.AdminUserRole;
import com.example.libraryse.eneity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminRoleMenuService adminRoleMenuService;
    @Autowired
    private AdminUserRoleService adminUserRoleService;
    @Autowired
    private AdminMenuDAO adminMenuDAO;

    public List<AdminMenu> getMenusByCurrentUser() {
        // 从数据库中获取当前用户
       String username = SecurityUtils.getSubject().getPrincipal().toString();
       // String username="test";
        User user = userService.getByUserName(username);


        // 获得当前用户对应的所有角色的 id 列表
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        Set<Integer> menuIds =new HashSet<>();
        // 查询出这些角色对应的所有菜单项
        for (Integer b :rids) {
            List<AdminRoleMenu> temp=adminRoleMenuService.findAllByRid(b);
            for(AdminRoleMenu a:temp)
                menuIds.add(a.getMid());

        }
//        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rids)
//                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
      // List<AdminMenu> menus = adminMenuDAO.findAllById(menuIds).stream().distinct().collect(Collectors.toList());
        Set<AdminMenu> menus =new HashSet<>();

        for(Integer b:menuIds){
           List <AdminMenu>temp= adminMenuDAO.findAllById(b);
        for(AdminMenu a:temp)
                menus.add(a);}

    List<AdminMenu > menuidsl =new ArrayList<>(menus);
        // 处理菜单项的结构
        handleMenus(menuidsl);
        return menuidsl;
    }
    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            List<AdminMenu> children = adminMenuDAO.getAllByParentId(menu.getId());
            menu.setChildren(children);
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
    }


}
