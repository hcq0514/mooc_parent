package com.mooc.model.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@ToString
@TableName("xc_user_role")

public class XcUserRole {

    @TableId
    private String id;

    private String userId;
    private String roleId;
    private String creator;
    private Date createTime;

}
