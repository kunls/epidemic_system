package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Student;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/students")
    public R<Page<Student>> getStudent(int page,int pageSize,String keyword) {
        return studentService.getStudent(page,pageSize,keyword);
    }
}
