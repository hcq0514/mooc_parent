package com.mooc.model.ucenter;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@TableName("xc_company_user")
public class XcCompanyUser implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
    @TableId
    private String id;
    private String companyId;
    private String userId;


}
