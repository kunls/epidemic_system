package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.service.ClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.epidemic_system.entity.Class;

import javax.annotation.Resource;

@RestController
public class ClassController {
    @Resource
    private ClassService classService;

    @GetMapping("/classes")
    public R<Page<Class>> getClass(Integer page, Integer pageSize, String keyword) {
        return classService.getClass(page, pageSize, keyword);
    }


}
