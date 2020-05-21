package com.example.libraryse.controller;

import com.example.libraryse.eneity.User;
import com.example.libraryse.result.Result;
import com.example.libraryse.result.ResultFactory;
import com.example.libraryse.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
@Controller
public class LoginController {
    @Autowired
    UserService userService;
@CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
    String username = requestUser.getUsername();
    Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
    try {
        subject.login(usernamePasswordToken);
        return ResultFactory.buildSuccessResult(username);
    } catch (AuthenticationException e) {
        String message = "账号密码错误";
        return ResultFactory.buildFailResult(message);
    }

    }
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }
    @ResponseBody
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }
    @ResponseBody
    //@RequiresPermissions("api/authentication")
    @GetMapping(value = "api/authentication")
    public String authentication(){
        System.out.println();
        return "身份认证成功";
    }

}
