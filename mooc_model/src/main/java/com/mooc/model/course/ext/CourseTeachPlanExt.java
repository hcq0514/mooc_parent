package com.mooc.model.course.ext;

import com.mooc.model.course.CourseTeachPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by admin on 2018/2/7.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CourseTeachPlanExt extends CourseTeachPlan {

    //媒资文件id
    private String mediaId;

    //媒资文件原始名称
    private String mediaFileOriginalName;

    //媒资文件访问地址
    private String mediaUrl;
}
