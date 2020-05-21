package com.example.libraryse.controller;

import com.example.libraryse.eneity.User;
import com.example.libraryse.result.Result;
import com.example.libraryse.result.ResultFactory;
import com.example.libraryse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/api/admin/roles")
    public Result listRoles() {
        System.out.println(userService.listAllUser());
        System.out.println("hahaha");
        return ResultFactory.buildSuccessResult(userService.listAllUser());
    }

    //@RequiresPermissions("yes")
    @GetMapping("/api/admin/user")
    public Result listUsers() {
        System.out.println(userService.listAllUser());
        System.out.println("hahaha");
        return ResultFactory.buildSuccessResult(userService.listAllUser());
    }
//    @PutMapping("/api/admin/user/status")
//    public Result updateUserStatus(@RequestBody @Valid User requestUser) {
//        userService.updateUserStatus(requestUser);
//        return ResultFactory.buildSuccessResult("用户状态更新成功");
//    }

    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody @Valid User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
}
}