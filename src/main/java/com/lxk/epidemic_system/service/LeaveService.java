package com.lxk.epidemic_system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.utils.R;
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

    R<Page<Leave>> getLeave(Integer page, Integer pageSize, String keyword);

    R<String> approve(Long id);

    R<String> reject(Long id);

    R<Page<Leave>> getCurrentInfo(Integer page, Integer pageSize, String username);

    R<String> submit(Leave realForm);
}
