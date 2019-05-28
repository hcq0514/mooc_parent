package com.mooc.model.cms.response;

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
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode, CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
