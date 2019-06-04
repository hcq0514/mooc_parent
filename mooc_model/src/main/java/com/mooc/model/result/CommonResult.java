package com.mooc.model.result;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import com.mooc.model.cms.CmsPage;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonResult<T> extends ResponseResult {
    T t;
    public CommonResult(ResultCode resultCode, T t) {
        super(resultCode);
        this.t = t;
    }
}
