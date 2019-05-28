package com.mooc.model.course.request;

import com.mooc.common.model.request.RequestData;
import lombok.Data;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
public class CourseListRequest extends RequestData {
    //公司Id
    private String companyId;
}
