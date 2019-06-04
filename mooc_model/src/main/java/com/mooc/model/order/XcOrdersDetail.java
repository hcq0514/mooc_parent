package com.mooc.model.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("xc_orders_detail")

public class XcOrdersDetail implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @TableId
    private String id;
    private String orderNumber;
    private String itemId;
    private Integer itemNum;
    private Float itemPrice;
    private String valid;
    private Date startTime;
    private Date endTime;
}
