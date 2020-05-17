package com.assignment.business_layer.mediator.request.query;

import com.assignment.business_layer.mediator.request.TRequest;

public class LogoutQuery implements TRequest {
    Integer id;

    public LogoutQuery(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
