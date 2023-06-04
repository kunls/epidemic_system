package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.Teacher;
import com.lxk.epidemic_system.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    @GetMapping("/teachers")
    public R<Page<Teacher>> getTeacher(Integer page,Integer pageSize,String keyword){
        return teacherService.getTeacher(page,pageSize,keyword);
    }
}
