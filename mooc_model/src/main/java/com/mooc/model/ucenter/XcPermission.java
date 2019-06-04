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
@TableName("xc_permission")
public class XcPermission {
    @TableId
    private String id;
    private String role_id;
    private String menu_id;
    private Date create_time;


}
