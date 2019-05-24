package com.mooc.model.cms.request;

import com.mooc.common.model.request.RequestData;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class QueryPageRequest extends RequestData {
    @ApiParam("站点id")
    private String siteId;
    @ApiParam("页面ID")
    private String pageId;
    @ApiParam("页面名称")
    private String pageName;
    @ApiParam("别名")
    private String pageAliase;
    @ApiParam("模版id")
    private String templateId;
}

