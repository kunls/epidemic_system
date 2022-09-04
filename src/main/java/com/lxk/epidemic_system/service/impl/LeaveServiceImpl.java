package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.entity.Leave;
import com.lxk.epidemic_system.service.LeaveService;
import com.lxk.epidemic_system.mapper.LeaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mia
* @description 针对表【leave_table】的数据库操作Service实现
* @createDate 2022-08-14 22:19:45
*/
@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave>
    implements LeaveService{

    @Override
    public Leave getLatestLeave(Leave realForm) {
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        if (realForm.getType() == "student") {
            wrapper.eq(Leave::getStudentId, realForm.getStudentId());
        } else {
            wrapper.eq(Leave::getTeacherId, realForm.getTeacherId());
        }
        wrapper.orderByDesc(Leave::getApplyTime);
        List<Leave> leaveList = this.list(wrapper);
        if (leaveList.size() != 0) {
            return leaveList.get(leaveList.size() - 1);
        }
        return null;
    }
}




