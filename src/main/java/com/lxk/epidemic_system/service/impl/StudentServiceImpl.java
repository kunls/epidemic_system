package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.Student;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.StudentService;
import com.lxk.epidemic_system.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author mia
* @description 针对表【student_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Override
    public R<Page<Student>> getStudent(int page, int pageSize, String keyword) {
        Page<Student> studentPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(keyword, "")) {
            wrapper.like(Student::getName, keyword);
        }
        wrapper.orderByDesc();
        this.page(studentPage, wrapper);
        System.out.println(studentPage.getRecords());
        return R.success(studentPage, HttpStatus.OK);
    }
}




