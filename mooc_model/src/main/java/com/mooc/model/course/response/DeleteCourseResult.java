package com.mooc.model.course.response;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class DeleteCourseResult extends ResponseResult {
    public DeleteCourseResult(ResultCode resultCode, String courseId) {
        super(resultCode);
        this.courseid = courseid;
    }
    private String courseid;

}
