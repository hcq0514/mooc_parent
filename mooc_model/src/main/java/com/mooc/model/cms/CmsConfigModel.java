package com.mooc.model.cms;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 *
 * @author admin
 * @date 2018/2/6
 */
@Data
@ToString
public class CmsConfigModel {
    private String key;
    private String name;
    private String url;
    private Map mapValue;
    private String value;

}
