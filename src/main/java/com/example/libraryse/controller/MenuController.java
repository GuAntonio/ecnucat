package com.example.libraryse.controller;

import com.example.libraryse.eneity.AdminMenu;
import com.example.libraryse.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;
    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        System.out.println(adminMenuService.getMenusByCurrentUser());
        return adminMenuService.getMenusByCurrentUser();
    }

}
