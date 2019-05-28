package com.mooc.model.cms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;


@Data
@ToString
@Document(collection = "cms_site")
public class CmsSite {

    @ApiModelProperty("站点ID")
    @Id
    private String siteId;
    @ApiModelProperty("站点名称")
    private String siteName;
    @ApiModelProperty("站点域名")
    private String siteDomain;
    @ApiModelProperty("站点端口")
    private String sitePort;
    @ApiModelProperty("站点访问地址")
    private String siteWebPath;
    @ApiModelProperty("创建时间")
    private Date siteCreateTime;

}
