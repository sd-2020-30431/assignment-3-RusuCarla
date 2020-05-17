package com.assignment.business_layer.mediator.response.queryResponse;

import com.assignment.business_layer.entity.Login;
import com.assignment.business_layer.mediator.response.TResponse;

public class LoginQueryResponse implements TResponse {

    Integer integer;

    public LoginQueryResponse(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
