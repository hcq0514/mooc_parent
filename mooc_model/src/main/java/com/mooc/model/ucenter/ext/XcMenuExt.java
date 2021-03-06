package com.mooc.model.ucenter.ext;

import com.mooc.model.course.ext.CategoryNode;
import com.mooc.model.ucenter.XcMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
