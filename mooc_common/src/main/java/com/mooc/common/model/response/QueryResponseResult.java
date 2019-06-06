package com.mooc.common.model.response;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    QueryResult queryResult;
    Page page;


    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

    public QueryResponseResult(CommonCode resultCode, Page dataPage) {
        super(resultCode);
        this.page = dataPage;
    }
}
