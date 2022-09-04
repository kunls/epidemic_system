package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.entity.Class;
import com.lxk.epidemic_system.service.ClassService;
import com.lxk.epidemic_system.mapper.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【class_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{

}




