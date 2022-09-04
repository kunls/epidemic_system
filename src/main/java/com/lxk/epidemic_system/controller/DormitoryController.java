package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Dormitory;
import com.lxk.epidemic_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/getDormitory")
    public R<Page<Dormitory>> getDormitory(Integer page, Integer pageSize, String keyword) {
        Page<Dormitory> dormitoryPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Dormitory> wrapper = new LambdaQueryWrapper<>();
        if (keyword != "") {
            wrapper.like(Dormitory::getBuildingId, keyword);
        }
        wrapper.orderByDesc();
        dormitoryService.page(dormitoryPage, wrapper);
        return R.success(dormitoryPage);
    }
}
