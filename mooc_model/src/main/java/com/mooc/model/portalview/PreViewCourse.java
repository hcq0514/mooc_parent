package com.mooc.model.portalview;

import com.mooc.model.course.CourseBase;
import com.mooc.model.course.CourseMarket;
import com.mooc.model.course.CoursePic;
import com.mooc.model.course.ext.CourseTeachPlanNode;
import com.mooc.model.report.ReportCourse;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@Document(collection = "pre_view_course")
public class PreViewCourse implements Serializable{

    @Id
    private String id;
    private CourseBase courseBase;
    private CourseMarket courseMarket;
    private CoursePic coursePic;
    private CourseTeachPlanNode teachplan;
    //课程统计信息
    private ReportCourse reportCourse;

}
