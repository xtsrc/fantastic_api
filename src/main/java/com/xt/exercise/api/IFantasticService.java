package com.xt.exercise.api;

import java.util.List;

import com.xt.exercise.bean.Fantastic;
import com.xt.exercise.bean.PageQuery;
import com.xt.exercise.bean.PageResult;
import com.xt.exercise.bean.QueryFantasticParam;
import com.xt.exercise.bean.RpcResponse;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 16:55
 * @Description:
 */
public interface IFantasticService {
    RpcResponse<List<Fantastic>> query(QueryFantasticParam queryFantasticParam);

    RpcResponse<PageResult<List<Fantastic>>> pageQuery(PageQuery<QueryFantasticParam> pageQuery);
}
