package com.assignment.business_layer.mediator.handler.commandHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.AddConsumptionDateCommand;
import com.assignment.business_layer.mediator.response.commandResponse.AddConsumptionDateResponse;
import com.assignment.business_layer.services.command.GroceriesCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddConsumptionDateHandler implements IHandler<AddConsumptionDateCommand, AddConsumptionDateResponse> {

    private final GroceriesCommandService groceriesCommandService;

    @Autowired
    public AddConsumptionDateHandler(GroceriesCommandService groceriesCommandService) {
        this.groceriesCommandService = groceriesCommandService;
    }

    @Override
    public AddConsumptionDateResponse handle(AddConsumptionDateCommand c) {
        return new AddConsumptionDateResponse(groceriesCommandService.addConsumptionDate(c.getConsumptionDto(),c.getId()));
    }
}
