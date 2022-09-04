package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Leave;
import com.lxk.epidemic_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = {"/leave", "/asktoleave"})
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/getLeave")
    public R<Page<Leave>> getLeave(Integer page, Integer pageSize, String keyword) {
        Page<Leave> leavePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        if (keyword != "") {
            wrapper.like(Leave::getStudentId, keyword);
        }
        wrapper.orderByDesc();
        leaveService.page(leavePage, wrapper);
        return R.success(leavePage);
    }

    @GetMapping("/allow")
    public R allow(Long id) {
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leave::getId, id);
        Leave leave = leaveService.getOne(wrapper);
        leave.setStatus("已通过");
        leaveService.saveOrUpdate(leave);
        return R.success("已通过");
    }

    @GetMapping("/refuse")
    public R refuse(Long id) {
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Leave::getId, id);
        Leave leave = leaveService.getOne(wrapper);
        leave.setStatus("已驳回");
        leaveService.saveOrUpdate(leave);
        return R.success("已驳回");
    }

    @GetMapping("/getLeaveInfo")
    public R<Page<Leave>> getCurrentInfo(Integer page, Integer pageSize, String username) {
        Page<Leave> leavePage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Leave> wrapper = new LambdaQueryWrapper<>();
        //根据学号
        wrapper.eq(Leave::getStudentId, username).or().eq(Leave::getTeacherId, username);
        wrapper.orderByDesc(Leave::getStatus);
        leaveService.page(leavePage, wrapper);
        return R.success(leavePage);
    }

    @PostMapping("/submit")
    public R submit(@RequestBody Leave realForm) {
        Leave leave = leaveService.getLatestLeave(realForm);

        if (leave!=null&&leave.getStatus() == "审核中") {
            return R.error("只能同时申请一次请假");
        }

        Long id= Long.valueOf((int)(Math.random()*9000+1000));
        realForm.setId(id);
        leaveService.saveOrUpdate(realForm);
        return R.success("ok");
    }
}
