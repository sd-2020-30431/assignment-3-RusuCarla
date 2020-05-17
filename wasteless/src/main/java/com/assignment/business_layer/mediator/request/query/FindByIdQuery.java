package com.assignment.business_layer.mediator.request.query;

import com.assignment.business_layer.mediator.request.TRequest;

public class FindByIdQuery implements TRequest {

    int id;

    public FindByIdQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
