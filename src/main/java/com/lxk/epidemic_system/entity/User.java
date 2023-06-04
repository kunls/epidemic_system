package com.lxk.epidemic_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @TableName user_table
 */
@TableName(value ="user_table")
@Data
public class User implements Serializable, UserDetails {
    private Long id;

    private Integer role;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;

    public String getRoles() {
        if (role == 1) {
            return "ROLE_ADMIN";
        } else if (role == 2) {
            return "ROLE_STUDENT";
        } else if (role == 3) {
            return "ROLE_TEACHER";
        }
        return "ROLE_ADMIN";
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}