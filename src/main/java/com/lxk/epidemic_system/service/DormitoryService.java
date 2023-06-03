package com.lxk.epidemic_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【dormitory_table】的数据库操作Service
* @createDate 2022-08-14 22:19:45
*/
@Service
public interface DormitoryService extends IService<Dormitory> {

    R<Page<Dormitory>> getDormitory(Integer page, Integer pageSize, String keyword);
}
