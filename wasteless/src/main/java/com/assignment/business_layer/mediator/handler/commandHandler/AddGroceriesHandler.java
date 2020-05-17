package com.assignment.business_layer.mediator.handler.commandHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.AddGroceriesCommand;
import com.assignment.business_layer.mediator.response.commandResponse.AddGroceriesResponse;
import com.assignment.business_layer.services.command.GroceriesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddGroceriesHandler implements IHandler<AddGroceriesCommand, AddGroceriesResponse> {

    private final GroceriesCommandService groceriesCommandService;

    @Autowired
    public AddGroceriesHandler(GroceriesCommandService groceriesCommandService) {
        this.groceriesCommandService = groceriesCommandService;
    }

    @Override
    public AddGroceriesResponse handle(AddGroceriesCommand c) {
        return new AddGroceriesResponse(groceriesCommandService.addGroceries(c.getGroceriesDto(),c.getId()));
    }
}
