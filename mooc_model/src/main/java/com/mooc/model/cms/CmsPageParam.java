package com.mooc.model.cms;

import lombok.Data;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
public class CmsPageParam {
   //参数名称
    private String pageParamName;
    //参数值
    private String pageParamValue;

}
