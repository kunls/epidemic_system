package com.lxk.epidemic_system.service;

import com.lxk.epidemic_system.entity.Leave;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【leave_table】的数据库操作Service
* @createDate 2022-08-14 22:19:45
*/
@Service
public interface LeaveService extends IService<Leave> {
    Leave getLatestLeave(Leave realForm);
}
