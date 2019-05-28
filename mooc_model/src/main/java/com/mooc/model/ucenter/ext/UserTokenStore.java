package com.mooc.model.ucenter.ext;

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
public class UserTokenStore extends AuthToken {
    String userId;//用户id
    String utype;//用户类型
    String companyId;//用户所属企业信息
}
