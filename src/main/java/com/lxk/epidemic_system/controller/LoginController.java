package com.lxk.epidemic_system.controller;

import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.User;
import com.lxk.epidemic_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController//要求json
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public R<Integer> login(@RequestParam(value = "error", required = false) String error) {
        //return userService.login(user);
        return R.error(error, HttpStatus.BAD_REQUEST);
    }

}
