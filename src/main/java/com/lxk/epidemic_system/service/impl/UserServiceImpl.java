package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.User;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.UserService;
import com.lxk.epidemic_system.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【user_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public R<Integer> login(User user) {
        String username=user.getUsername();
        String password=user.getPassword();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user2 = this.getOne(wrapper);
        if (user2!=null&&user2.getPassword().equals(password)) {
            return R.success(user2.getType(), HttpStatus.OK);
        }
        return R.error("用户名或密码错误", HttpStatus.BAD_REQUEST);
    }
}




