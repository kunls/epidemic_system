package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.User;
import com.lxk.epidemic_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//要求json
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        String username=user.getUsername();
        String password=user.getPassword();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user2 = userService.getOne(wrapper);
        if (user2!=null&&user2.getPassword().equals(password)) {
            return R.success(user2.getType());
        }
        return R.error("用户名或密码错误");
    }

}
