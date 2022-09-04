package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.epidemic_system.entity.Class;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/getClass")
    public R<Page<Class>> getClass(Integer page, Integer pageSize, String keyword) {
        Page<Class> classPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Class> wrapper = new LambdaQueryWrapper<>();
        if (keyword != "") {
            wrapper.like(Class::getId, keyword);
        }
        wrapper.orderByDesc();
        classService.page(classPage, wrapper);
        return R.success(classPage);
    }
}
