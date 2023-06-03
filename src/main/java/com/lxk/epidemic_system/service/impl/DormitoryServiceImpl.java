package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Dormitory;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.DormitoryService;
import com.lxk.epidemic_system.mapper.DormitoryMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
* @author mia
* @description 针对表【dormitory_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory>
    implements DormitoryService{

    @Override
    public R<Page<Dormitory>> getDormitory(Integer page, Integer pageSize, String keyword) {
        Page<Dormitory> dormitoryPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Dormitory> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(keyword, "")) {
            wrapper.like(Dormitory::getBuildingId, keyword);
        }
        wrapper.orderByDesc();
        this.page(dormitoryPage, wrapper);
        return R.success(dormitoryPage, HttpStatus.OK);
    }
}




