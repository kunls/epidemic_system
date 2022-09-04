package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.entity.Student;
import com.lxk.epidemic_system.service.StudentService;
import com.lxk.epidemic_system.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【student_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




