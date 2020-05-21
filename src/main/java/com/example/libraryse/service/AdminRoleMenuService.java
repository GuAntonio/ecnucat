package com.example.libraryse.service;

import com.example.libraryse.dao.AdminRoleMenuDAO;
import com.example.libraryse.eneity.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleMenuService {
    @Autowired
    private AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(Integer rid) {

            return adminRoleMenuDAO.findAllByRid(rid);
        }

}
