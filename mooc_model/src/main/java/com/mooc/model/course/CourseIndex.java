package com.mooc.model.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("course_index")
public class CourseIndex implements Serializable {
    private static final long serialVersionUID = -916357110051689587L;
    @TableId
    private String id;

    private String name;
    private String users;
    private String mt;
    private String st;
    private String grade;
    private String studymodel;
    private String teachmode;
    private String description;
    @ApiParam("图片")
    private String pic;
    private Date timestamp;
    private String charge;
    private String valid;
    private String qq;
    private Float price;
    private Float price_old;
    private Date expires;
    @ApiParam("课程计划")
    private String teachplan;


}
