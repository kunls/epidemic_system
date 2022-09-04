package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Student;
import com.lxk.epidemic_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public R<Page<Student>> getStudent(int page,int pageSize,String keyword) {
        Page<Student> studentPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        if (keyword != "") {
            wrapper.like(Student::getName, keyword);
        }
        wrapper.orderByDesc();
        studentService.page(studentPage, wrapper);
        System.out.println(studentPage.getRecords());
        return R.success(studentPage);
    }
}
