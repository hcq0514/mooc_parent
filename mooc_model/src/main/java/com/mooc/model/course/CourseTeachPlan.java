package com.mooc.model.course;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/7.
 */
@Data
@ToString
@TableName("course_teachplan")
public class CourseTeachPlan implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;
    @TableId(type = IdType.UUID)
    private String id;
    private String pname;
    private String parentid;
    private String grade;
    private String ptype;
    private String description;
    private String courseid;
    private String status;
    private Integer orderby;
    private Double timelength;
    private String trylearn;

}
