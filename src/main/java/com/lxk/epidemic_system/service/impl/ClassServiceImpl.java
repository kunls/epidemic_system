package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Class;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.ClassService;
import com.lxk.epidemic_system.mapper.ClassMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author mia
* @description 针对表【class_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{
    public R<Page<Class>> getClass(Integer page, Integer pageSize, String keyword) {
        Page<Class> classPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Class> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(keyword, "")) {
            wrapper.like(Class::getId, keyword);
        }
        wrapper.orderByDesc();
        this.page(classPage, wrapper);
        return R.success(classPage, HttpStatus.OK);
    }
}




