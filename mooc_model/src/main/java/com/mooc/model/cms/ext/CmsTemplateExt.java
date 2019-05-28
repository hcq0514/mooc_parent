package com.mooc.model.cms.ext;

import com.mooc.model.cms.CmsTemplate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

}
