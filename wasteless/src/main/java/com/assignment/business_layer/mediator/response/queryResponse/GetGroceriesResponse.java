package com.assignment.business_layer.mediator.response.queryResponse;

import com.assignment.business_layer.mediator.response.TResponse;
import com.assignment.presentation_layer.dto.GroceriesDto;

import java.util.ArrayList;

public class GetGroceriesResponse implements TResponse {

    ArrayList<GroceriesDto> groceriesDtos;

    public GetGroceriesResponse(ArrayList<GroceriesDto> groceriesDtos) {
        this.groceriesDtos = groceriesDtos;
    }

    public ArrayList<GroceriesDto> getGroceriesDtos() {
        return groceriesDtos;
    }

    public void setGroceriesDtos(ArrayList<GroceriesDto> groceriesDtos) {
        this.groceriesDtos = groceriesDtos;
    }
}
