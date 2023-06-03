package com.lxk.epidemic_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【student_table】的数据库操作Service
* @createDate 2022-08-14 22:19:45
*/
@Service
public interface StudentService extends IService<Student> {

    R<Page<Student>> getStudent(int page, int pageSize, String keyword);
}
