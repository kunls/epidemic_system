package com.lxk.epidemic_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Leave;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.LeaveService;
import com.lxk.epidemic_system.mapper.LeaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public R<Page<Leave>> getLeave(Integer page, Integer pageSize, String keyword) {
        Page<Leave> leavePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(keyword, "")) {
            wrapper.like(Leave::getStudentId, keyword);
        }
        wrapper.orderByDesc();
        this.page(leavePage, wrapper);
        return R.success(leavePage, HttpStatus.OK);
    }

    @Override
    public R<String> approve(Long id) {
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leave::getId, id);
        Leave leave = this.getOne(wrapper);
        leave.setStatus("已通过");
        this.saveOrUpdate(leave);
        return R.success("已通过",HttpStatus.NO_CONTENT);
    }

    @Override
    public R<String> reject(Long id) {
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leave::getId, id);
        Leave leave = this.getOne(wrapper);
        leave.setStatus("已驳回");
        this.saveOrUpdate(leave);
        return R.success("已驳回",HttpStatus.NO_CONTENT);
    }

    @Override
    public R<Page<Leave>> getCurrentInfo(Integer page, Integer pageSize, String username) {
        Page<Leave> leavePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        //根据学号
        wrapper.eq(Leave::getStudentId, username).or().eq(Leave::getTeacherId, username);
        wrapper.orderByDesc(Leave::getStatus);
        this.page(leavePage, wrapper);
        return R.success(leavePage, HttpStatus.OK);
    }

    @Override
    public R<String> submit(Leave realForm) {
        Leave leave = this.getLatestLeave(realForm);

        if (leave!=null&& Objects.equals(leave.getStatus(), "审核中")) {
            return R.error("只能同时申请一次请假", HttpStatus.BAD_REQUEST);
        }

        Long id= (long) (int) (Math.random() * 9000 + 1000);
        realForm.setId(id);
        this.saveOrUpdate(realForm);
        return R.success("ok", HttpStatus.CREATED);
    }
}




