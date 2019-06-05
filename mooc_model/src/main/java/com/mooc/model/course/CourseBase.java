package com.mooc.model.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;
import static com.baomidou.mybatisplus.annotation.IdType.UUID;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("course_base")
public class CourseBase implements Serializable {
    private static final long serialVersionUID = -916357110051689486L;
    @TableId(type = UUID)
    private String id;
    private String name;
    private String users;
    private String mt;
    private String st;
    private String grade;
    private String studymodel;
    private String teachmode;
    private String description;
    private String status;
    private String companyId;
    private String userId;

}
