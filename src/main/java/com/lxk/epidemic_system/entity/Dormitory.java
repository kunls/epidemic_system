package com.lxk.epidemic_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName dormitory_table
 */
@TableName(value ="dormitory_table")
@Data
public class Dormitory implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 
     */
    private Long buildingId;

    /**
     * 
     */
    private Integer floor;

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