package com.example.libraryse.service;

import com.example.libraryse.dao.UserMapper;
import com.example.libraryse.eneity.AdminRole;
import com.example.libraryse.eneity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    UserMapper userDAO;

    public boolean isExist(String username) {
        User user = getByUserName(username);
        return null!=user;
    }

    public User getByUserName(String username) {
        return userDAO.getUserByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userDAO.insertUser(user);
    }
    public List<User> listAllUser(){

            List<User> users =  userDAO.listAllUser();
            List<AdminRole> roles;
            for (User user : users) {
                roles = adminRoleService.listRolesByUser(user.getUsername());
                user.setRoles(roles);
            }
            return users;


    }

    public User resetPassword(User user) {
        String name=user.getUsername();
        User userInDB = userDAO.getUserByUsername(name);
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
       userDAO.updateUser(userInDB);
       return  userDAO.getUserByUsername(name);
    }

    public void editUser(User user) {
        User userInDB = userDAO.getUserByUsername(user.getUsername());
        userInDB.setName(user.getName());
        userInDB.setPhone(user.getPhone());
        userInDB.setEmail(user.getEmail());
        userDAO.updateUser(userInDB);
       adminUserRoleService.saveRoleChanges(userInDB.getId(), user.getRoles());
    }

}
