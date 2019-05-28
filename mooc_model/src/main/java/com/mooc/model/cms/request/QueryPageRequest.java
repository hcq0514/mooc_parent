package com.mooc.model.cms.request;

import com.mooc.common.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * @author : hcq
 * @date : 2019/5/28
 */
@EqualsAndHashCode(callSuper = true)
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

