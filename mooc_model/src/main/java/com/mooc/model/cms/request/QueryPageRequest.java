package com.mooc.model.cms.request;

import com.mooc.common.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class QueryPageRequest extends RequestData {
    @ApiModelProperty("站点id")
    private String siteId;
    @ApiModelProperty("页面ID")
    private String pageId;
    @ApiModelProperty("页面名称")
    private String pageName;
    @ApiModelProperty("别名")
    private String pageAliase;
    @ApiModelProperty("模版id")
    private String templateId;
}

