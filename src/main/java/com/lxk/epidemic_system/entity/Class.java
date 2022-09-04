package com.lxk.epidemic_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName class_table
 */
@TableName(value ="class_table")
@Data
public class Class implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String major;

    /**
     * 
     */
    private String grade;

    /**
     * 
     */
    private Integer studentCount;

    /**
     * 
     */
    private Integer uncheckedCount;

    /**
     * 
     */
    private Integer isolationCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}