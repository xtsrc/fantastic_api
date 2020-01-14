package com.xt.exercise.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:22
 * @Description:
 */
public final class QueryFantasticParam implements Serializable {

    private static final long serialVersionUID = 6983823845626912068L;

    @NotBlank(message = "业务线Id不能为空")
    private String BusinessId;

    public String getBusinessId() {
        return BusinessId;
    }

    public void setBusinessId(String businessId) {
        BusinessId = businessId;
    }
}
