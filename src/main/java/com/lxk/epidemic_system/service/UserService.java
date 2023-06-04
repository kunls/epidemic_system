package com.lxk.epidemic_system.service;

import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mia
* @description 针对表【user_table】的数据库操作Service
* @createDate 2022-08-14 22:19:45
*/
public interface UserService extends IService<User> {

    R<Integer> login(User user);

    User findByUsername(String username);
}
