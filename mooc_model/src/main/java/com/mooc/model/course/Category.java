package com.mooc.model.course;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mooc.model.course.ext.CategoryNode;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
@Data
@ToString
@TableName("course_category")
public class Category implements Serializable {
    private static final long serialVersionUID = -906357110051689484L;
    @TableId
    private String id;
    private String name;
    private String label;
    private String parentid;
    private String isshow;
    private Integer orderby;
    private Integer isleaf;

    @TableField(exist = false)
    List<Category> children;

}
