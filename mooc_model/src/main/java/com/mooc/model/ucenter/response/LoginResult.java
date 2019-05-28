package com.mooc.model.ucenter.response;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
@NoArgsConstructor
public class LoginResult extends ResponseResult {
    public LoginResult(ResultCode resultCode, String token) {
        super(resultCode);
        this.token = token;
    }
    private String token;
}
