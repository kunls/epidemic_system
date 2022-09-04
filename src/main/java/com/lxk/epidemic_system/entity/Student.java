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
 * @TableName student_table
 */
@TableName(value ="student_table")
@Data
public class Student implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private Long classId;

    /**
     * 
     */
    private Long dormitoryId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String grade;

    /**
     * 
     */
    private String major;

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