package com.lxk.epidemic_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName epidemic_state
 */
@TableName(value ="epidemic_state")
@Data
public class EpidemicState implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String week;

    /**
     * 
     */
    private Integer studentCount;

    /**
     * 
     */
    private Integer teacherCount;

    /**
     * 
     */
    private Integer classCount;

    /**
     * 
     */
    private Integer dormitoryCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}