package com.assignment.business_layer.mediator.request.query;

import com.assignment.business_layer.mediator.request.TRequest;

public class GetGroceriesQuery implements TRequest {

    int id;

    public GetGroceriesQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
