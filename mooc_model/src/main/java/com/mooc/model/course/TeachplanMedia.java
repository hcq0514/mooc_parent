package com.mooc.model.course;

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
@TableName("teachplan_media")
public class TeachplanMedia implements Serializable {
    private static final long serialVersionUID = -916357110051689485L;
    @TableId
    private String teachplanId;

    private String mediaId;

    private String mediaFileOriginalName;
    private String mediaUrl;
    private String courseId;

}
