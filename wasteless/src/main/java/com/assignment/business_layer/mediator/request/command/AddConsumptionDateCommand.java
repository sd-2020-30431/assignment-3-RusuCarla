package com.assignment.business_layer.mediator.request.command;

import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.presentation_layer.dto.ConsumptionDto;

public class AddConsumptionDateCommand implements TRequest {

    ConsumptionDto consumptionDto;
    int id;

    public AddConsumptionDateCommand(ConsumptionDto consumptionDto, int id) {
        this.consumptionDto = consumptionDto;
        this.id = id;
    }

    public ConsumptionDto getConsumptionDto() {
        return consumptionDto;
    }

    public void setConsumptionDto(ConsumptionDto consumptionDto) {
        this.consumptionDto = consumptionDto;
    }

    public int getId() {
        return id;
    }
}
