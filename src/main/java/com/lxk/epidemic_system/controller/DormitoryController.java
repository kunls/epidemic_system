package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Dormitory;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/dormitories")
    public R<Page<Dormitory>> getDormitory(Integer page, Integer pageSize, String keyword) {
        return dormitoryService.getDormitory(page, pageSize, keyword);
    }


}
