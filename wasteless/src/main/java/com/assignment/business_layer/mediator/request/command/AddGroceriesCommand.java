package com.assignment.business_layer.mediator.request.command;

import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.presentation_layer.dto.GroceriesDto;

public class AddGroceriesCommand implements TRequest {
    GroceriesDto groceriesDto;
    int id;

    public AddGroceriesCommand(GroceriesDto groceriesDto, int id) {
        this.groceriesDto = groceriesDto;
        this.id = id;
    }

    public GroceriesDto getGroceriesDto() {
        return groceriesDto;
    }

    public void setGroceriesDto(GroceriesDto groceriesDto) {
        this.groceriesDto = groceriesDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
