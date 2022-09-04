package com.lxk.epidemic_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName teacher_table
 */
@TableName(value ="teacher_table")
@Data
public class Teacher implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Date checkedTime;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer isolation;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}