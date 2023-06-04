package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.Student;
import com.lxk.epidemic_system.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
