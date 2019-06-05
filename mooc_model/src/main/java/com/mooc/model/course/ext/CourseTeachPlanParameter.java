package com.mooc.model.course.ext;

import com.mooc.model.course.CourseTeachPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CourseTeachPlanParameter extends CourseTeachPlan {

    //二级分类ids
    List<String> bIds;
    //三级分类ids
    List<String> cIds;

}
