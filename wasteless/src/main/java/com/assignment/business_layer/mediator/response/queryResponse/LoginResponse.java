package com.assignment.business_layer.mediator.response.queryResponse;

import com.assignment.business_layer.mediator.response.TResponse;

public class LoginResponse implements TResponse {

    Integer integer;

    public LoginResponse(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
