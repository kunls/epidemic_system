package com.lxk.epidemic_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
import com.lxk.epidemic_system.entity.Class;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【class_table】的数据库操作Service
* @createDate 2022-08-14 22:19:45
*/
@Service
public interface ClassService extends IService<Class> {

    R<Page<Class>> getClass(Integer page, Integer pageSize, String keyword);
}
