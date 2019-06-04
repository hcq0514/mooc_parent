package com.mooc.model.learning;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("xc_learning_course")
public class XcLearningCourse implements Serializable {
    private static final long serialVersionUID = -916357210051789799L;
    @TableId
    private String id;
    private String courseId;
    private String userId;
    private String valid;
    private Date startTime;
    private Date endTime;
    private String status;

}
