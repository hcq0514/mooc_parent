package com.mooc.model.errorCode;

import com.mooc.common.model.response.ResultCode;
import io.swagger.annotations.ApiParam;
import lombok.ToString;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@ToString
public enum CourseErrorCode implements ResultCode {
    //course base 异常从24201开始

    COURSE_BASE_ADD_ALREADY_EXIST(false, 24201, "课程已存在！"),
    COURSE_BASE_NOT_EXIST(false, 24202, "课程不存在！"),
    //course market 异常从24211开始
    COURSE_MARKET_ADD_ALREADY_EXIST(false, 24211, "课程营销已存在！"),
    COURSE_MARKET_NOT_EXIST(false, 24212, "课程营销不存在！");

    @ApiParam("是否成功")
    boolean success;
    @ApiParam("操作代码")
    int code;
    @ApiParam("提示信息")
    String message;

    CourseErrorCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
