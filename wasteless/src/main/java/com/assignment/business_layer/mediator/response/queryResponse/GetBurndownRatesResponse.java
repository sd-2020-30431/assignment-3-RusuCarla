package com.assignment.business_layer.mediator.response.queryResponse;

import com.assignment.business_layer.mediator.response.TResponse;

import java.util.ArrayList;

public class GetBurndownRatesResponse implements TResponse {

    ArrayList<Integer> burndownRates;

    public GetBurndownRatesResponse(ArrayList<Integer> burndownRates) {
        this.burndownRates = burndownRates;
    }

    public ArrayList<Integer> getBurndownRates() {
        return burndownRates;
    }

    public void setBurndownRates(ArrayList<Integer> burndownRates) {
        this.burndownRates = burndownRates;
    }
}
