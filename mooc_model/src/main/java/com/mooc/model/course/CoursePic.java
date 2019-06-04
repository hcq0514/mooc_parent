package com.mooc.model.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("course_pic")
public class CoursePic implements Serializable {
    private static final long serialVersionUID = -916357110051689486L;
    @TableId
    private String courseid;
    private String pic;

}
