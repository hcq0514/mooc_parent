package com.mooc.model.task;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
@TableName("xc_task")
public class XcTask implements Serializable {

    @TableId
    private String id;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    private String taskType;
    private String mqExchange;
    private String mqRoutingkey;
    private String requestBody;
    private Integer version;
    private String status;
    private String errormsg;
}
