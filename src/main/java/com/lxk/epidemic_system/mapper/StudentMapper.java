package com.lxk.epidemic_system.mapper;

import com.lxk.epidemic_system.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mia
* @description 针对表【student_table】的数据库操作Mapper
* @createDate 2022-08-14 22:19:45
* @Entity com.lxk.epidemic_system.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




