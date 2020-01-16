package com.xt.exercise.api;

import java.util.List;
import java.util.function.Function;

import com.xt.exercise.bean.Fantastic;
import com.xt.exercise.bean.PageQuery;
import com.xt.exercise.bean.PageResult;
import com.xt.exercise.bean.QueryFantasticParam;
import com.xt.exercise.bean.RpcResponse;
import com.xt.exercise.bean.ScrollQuery;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 16:55
 * @Description:
 */
public interface IFantasticService {
    RpcResponse<List<Fantastic>> query(QueryFantasticParam queryFantasticParam);

    RpcResponse<PageResult<Fantastic>> pageQuery(PageQuery<QueryFantasticParam> pageQuery);

    RpcResponse scrollWithFunction(ScrollQuery<QueryFantasticParam> scrollQuery,
            Function<List<Fantastic>, Long> function);

}
