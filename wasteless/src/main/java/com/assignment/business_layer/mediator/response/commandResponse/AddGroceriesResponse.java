package com.assignment.business_layer.mediator.response.commandResponse;

import com.assignment.business_layer.mediator.response.TResponse;

public class AddGroceriesResponse implements TResponse {
    int result;

    public AddGroceriesResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
