package com.lxk.epidemic_system.mapper;

import com.lxk.epidemic_system.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author mia
* @description 针对表【dormitory_table】的数据库操作Mapper
* @createDate 2022-08-14 22:19:45
* @Entity com.lxk.epidemic_system.entity.Dormitory
*/
@Mapper
public interface DormitoryMapper extends BaseMapper<Dormitory> {

}




