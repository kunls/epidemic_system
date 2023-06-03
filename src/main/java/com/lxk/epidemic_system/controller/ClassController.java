package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxk.epidemic_system.entity.Class;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
public class ClassController {
    @Resource
    private ClassService classService;

    @GetMapping("/classes")
    public R<Page<Class>> getClass(Integer page, Integer pageSize, String keyword) {
        return classService.getClass(page, pageSize, keyword);
    }


}
