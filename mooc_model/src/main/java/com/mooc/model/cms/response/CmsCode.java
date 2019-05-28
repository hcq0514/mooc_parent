package com.mooc.model.cms.response;

import com.mooc.common.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.ToString;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@ToString
public enum CmsCode implements ResultCode {
    //cms page 页面异常从24001-24010
    CMS_PAGE_ADD_ALREADY_EXIST(false, 24001, "页面已存在！"),
    CMS_PAGE_NOT_EXIST(false, 24002, "页面不存在！"),
    //cms site 页面异常从24011-24020
    CMS_SITE_ADD_ALREADY_EXIST(false, 24011, "站点已存在！"),
    CMS_SITE_NOT_EXIST(false, 24012, "站点不存在！"),
    //cms template 页面异常从24021-24030
    CMS_TEMPLATE_ADD_ALREADY_EXIST(false, 24011, "模版已存在！"),
    CMS_TEMPLATE_NOT_EXIST(false, 24012, "模版不存在！");
//    CMS_GENERATEHTML_DATAURLISNULL(false, 24002, "从页面信息中找不到获取数据的url！"),
//    CMS_GENERATEHTML_DATAISNULL(false, 24003, "根据页面的数据url获取不到数据！"),
//    CMS_GENERATEHTML_TEMPLATEISNULL(false, 24004, "页面模板为空！"),
//    CMS_GENERATEHTML_HTMLISNULL(false, 24005, "生成的静态html为空！"),
//    CMS_GENERATEHTML_SAVEHTMLERROR(false, 24005, "保存静态html出错！"),
//    CMS_COURSE_PERVIEWISNULL(false, 24007, "预览页面为空！");

    @ApiParam("是否成功")
    boolean success;
    @ApiParam("操作代码")
    int code;
    @ApiParam("提示信息")
    String message;

    CmsCode(boolean success, int code, String message) {
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
