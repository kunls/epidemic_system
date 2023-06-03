package com.lxk.epidemic_system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxk.epidemic_system.config.R;
import com.lxk.epidemic_system.entity.Leave;
import com.lxk.epidemic_system.enums.HttpStatus;
import com.lxk.epidemic_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;


@RestController
public class LeaveController {
    @Resource
    private LeaveService leaveService;

    @GetMapping("/leaves")
    public R<Page<Leave>> getLeave(Integer page, Integer pageSize, String keyword) {
        return leaveService.getLeave(page, pageSize, keyword);
    }

    @GetMapping("/leaves/{id}/approve")
    public R<String> approve(@PathVariable Long id) {
        return leaveService.approve(id);
    }

    @GetMapping("/leaves/{id}/reject")
    public R<String> reject(@PathVariable Long id) {
        return leaveService.reject(id);
    }

    @GetMapping("/students/{username}/leaves")
    public R<Page<Leave>> getCurrentInfo(Integer page, Integer pageSize, @PathVariable String username) {
        return leaveService.getCurrentInfo(page, pageSize, username);
    }

    @PostMapping("/leaves")
    public R<String> submit(@RequestBody Leave realForm) {
        return leaveService.submit(realForm);
    }
}
