package com.mooc.model.course.ext;

import com.mooc.model.course.CourseBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by admin on 2018/2/10.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CourseInfo extends CourseBase {

    //课程图片
    private String pic;

}
