package com.mooc.model.cms.response;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import com.mooc.model.cms.CmsPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by mrt on 2018/3/31.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CmsResult<T> extends ResponseResult {
    T t;
    public CmsResult(ResultCode resultCode, T t) {
        super(resultCode);
        this.t = t;
    }
}
