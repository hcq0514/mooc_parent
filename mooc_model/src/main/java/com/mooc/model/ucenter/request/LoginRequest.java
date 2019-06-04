package com.mooc.model.ucenter.request;

import com.mooc.common.model.request.RequestData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class LoginRequest extends RequestData {

    String username;
    String password;
    String verifycode;

}
