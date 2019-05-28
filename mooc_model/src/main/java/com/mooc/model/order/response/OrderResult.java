package com.mooc.model.order.response;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import com.mooc.model.order.XcOrders;
import lombok.Data;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
public class OrderResult extends ResponseResult {
    private XcOrders xcOrders;
    public OrderResult(ResultCode resultCode, XcOrders xcOrders) {
        super(resultCode);
        this.xcOrders = xcOrders;
    }


}
