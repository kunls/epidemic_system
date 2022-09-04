package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Teacher;
import com.lxk.epidemic_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getTeacher")
    public R<Page<Teacher>> getTeacher(Integer page,Integer pageSize,String keyword){
        Page<Teacher> teacherPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        if (keyword != "") {
            wrapper.like(Teacher::getName, keyword);
        }
        wrapper.orderByDesc();
        teacherService.page(teacherPage, wrapper);
        return R.success(teacherPage);
    }
}
