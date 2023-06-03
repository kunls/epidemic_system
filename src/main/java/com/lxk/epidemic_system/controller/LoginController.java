package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.User;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController//要求json
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public R<Integer> login(@RequestBody User user) {
        return userService.login(user);
    }

}
