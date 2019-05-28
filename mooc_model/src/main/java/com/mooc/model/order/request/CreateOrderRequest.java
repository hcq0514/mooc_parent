package com.mooc.model.order.request;

import com.mooc.common.model.request.RequestData;
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
public class CreateOrderRequest extends RequestData {

    String courseId;

}
