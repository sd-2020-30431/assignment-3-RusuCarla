package com.assignment.business_layer.mediator.response.commandResponse;

import com.assignment.business_layer.mediator.response.TResponse;

public class AddConsumptionDateResponse implements TResponse {
    int result;

    public AddConsumptionDateResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
