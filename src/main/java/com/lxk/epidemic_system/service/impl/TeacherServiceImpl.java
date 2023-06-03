package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Teacher;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.TeacherService;
import com.lxk.epidemic_system.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author mia
* @description 针对表【teacher_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

    @Override
    public R<Page<Teacher>> getTeacher(Integer page, Integer pageSize, String keyword) {
        Page<Teacher> teacherPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(keyword, "")) {
            wrapper.like(Teacher::getName, keyword);
        }
        wrapper.orderByDesc();
        this.page(teacherPage, wrapper);
        return R.success(teacherPage, HttpStatus.OK);
    }
}




