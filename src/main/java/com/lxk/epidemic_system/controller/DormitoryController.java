package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.Dormitory;
import com.lxk.epidemic_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/dormitories")
    public R<Page<Dormitory>> getDormitory(Integer page, Integer pageSize, String keyword) {
        return dormitoryService.getDormitory(page, pageSize, keyword);
    }


}
