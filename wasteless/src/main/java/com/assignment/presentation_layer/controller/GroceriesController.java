package com.assignment.presentation_layer.controller;

import com.assignment.business_layer.mediator.Mediator;
import com.assignment.business_layer.mediator.handler.commandHandler.AddConsumptionDateHandler;
import com.assignment.business_layer.mediator.handler.commandHandler.AddGroceriesHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.GetBurndownRatesHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.GetGroceriesHandler;
import com.assignment.business_layer.mediator.request.command.AddConsumptionDateCommand;
import com.assignment.business_layer.mediator.request.command.AddGroceriesCommand;
import com.assignment.business_layer.mediator.request.query.GetBurndownRatesQuery;
import com.assignment.business_layer.mediator.request.query.GetGroceriesQuery;
import com.assignment.business_layer.mediator.response.commandResponse.AddConsumptionDateResponse;
import com.assignment.business_layer.mediator.response.commandResponse.AddGroceriesResponse;
import com.assignment.business_layer.mediator.response.queryResponse.GetBurndownRatesResponse;
import com.assignment.business_layer.mediator.response.queryResponse.GetGroceriesResponse;
import com.assignment.presentation_layer.dto.*;
import com.assignment.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/groceries")
public class GroceriesController {

    //@Autowired
    //GroceriesService groceriesService;

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/addGrocery")
    public ResponseEntity<StringObj> addGrocery(@RequestBody GroceriesDto groceriesDto, @RequestHeader("userId") String id) {
        if (!Validator.validateGroceriesDto(groceriesDto))
            return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);

        //groceriesService.addGroceries(groceriesDto, Integer.parseInt(id));

        AddGroceriesCommand addGroceriesCommand = new AddGroceriesCommand(groceriesDto, Integer.parseInt(id));
        AddGroceriesHandler addGroceriesHandler = (AddGroceriesHandler)mediator.<AddGroceriesCommand, AddGroceriesResponse>getHandler(addGroceriesCommand);
        AddGroceriesResponse addGroceriesResponse = addGroceriesHandler.handle(addGroceriesCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @PostMapping(value = "/addConsumptionDate")
    public ResponseEntity addConsumptionDate(@RequestBody ConsumptionDto consumptionDto, @RequestHeader("userId") String id) {
        if (!Validator.validateConsumptionDto(consumptionDto))
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        //groceriesService.addConsumptionDate(consumptionDto, Integer.parseInt(id));

        AddConsumptionDateCommand addConsumptionDateCommand = new AddConsumptionDateCommand(consumptionDto, Integer.parseInt(id));
        AddConsumptionDateHandler addConsumptionDateHandler = (AddConsumptionDateHandler)mediator.<AddConsumptionDateCommand, AddConsumptionDateResponse>getHandler(addConsumptionDateCommand);
        AddConsumptionDateResponse addConsumptionDateResponse = addConsumptionDateHandler.handle(addConsumptionDateCommand);

        System.out.println("ALL GOOD "+ addConsumptionDateResponse.getResult());

        return new ResponseEntity( HttpStatus.OK);
    }

    @GetMapping(value = "/getGroceries")
    public ResponseEntity<ArrayList<GroceriesDto>> getCustomers(@RequestHeader("userId") String id) {
        //ArrayList<GroceriesDto> groceriesDtos = groceriesService.getGroceries(Integer.parseInt(id));

        GetGroceriesQuery getGroceriesQuery = new GetGroceriesQuery(Integer.parseInt(id));
        GetGroceriesHandler getGroceriesHandler = (GetGroceriesHandler)mediator.<GetGroceriesQuery, GetGroceriesResponse>getHandler(getGroceriesQuery);
        GetGroceriesResponse getGroceriesResponse = getGroceriesHandler.handle(getGroceriesQuery);

        return new ResponseEntity<>(getGroceriesResponse.getGroceriesDtos(), HttpStatus.OK);
    }

    @GetMapping(value = "/burndownRate")
    public ResponseEntity<ArrayList<Integer>> burndownRate(@RequestHeader("userId") String id) {
        //ArrayList<Integer> rates = groceriesService.getBurndownRates(Integer.parseInt(id));

        GetBurndownRatesQuery getBurndownRatesQuery = new GetBurndownRatesQuery(Integer.parseInt(id));
        GetBurndownRatesHandler getBurndownRatesHandler = (GetBurndownRatesHandler)mediator.<GetBurndownRatesQuery, GetBurndownRatesResponse>getHandler(getBurndownRatesQuery);
        GetBurndownRatesResponse getBurndownRatesResponse = getBurndownRatesHandler.handle(getBurndownRatesQuery);

        return new ResponseEntity<>(getBurndownRatesResponse.getBurndownRates(), HttpStatus.OK);
    }
}
