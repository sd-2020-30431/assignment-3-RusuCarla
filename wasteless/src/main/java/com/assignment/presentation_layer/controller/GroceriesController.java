package com.assignment.presentation_layer.controller;

import com.assignment.business_layer.mediator.Mediator;
import com.assignment.business_layer.mediator.handler.queryHandler.GetBurndownRatesHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.GetGroceriesHandler;
import com.assignment.business_layer.mediator.request.query.GetBurndownRatesQuery;
import com.assignment.business_layer.mediator.request.query.GetGroceriesQuery;
import com.assignment.business_layer.mediator.response.queryResponse.GetBurndownRatesResponse;
import com.assignment.business_layer.mediator.response.queryResponse.GetGroceriesResponse;
import com.assignment.presentation_layer.dto.*;
import com.assignment.business_layer.services.GroceriesService;
import com.assignment.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/groceries")
public class GroceriesController {

    @Autowired
    GroceriesService groceriesService;

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/addGrocery")
    public ResponseEntity<StringObj> addGrocery(@RequestBody GroceriesDto groceriesDto, @RequestHeader("userId") String id) {
        if (!Validator.validateGroceriesDto(groceriesDto))
            return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);

        groceriesService.addGroceries(groceriesDto, Integer.parseInt(id));
        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @PostMapping(value = "/addConsumptionDate")
    public ResponseEntity addConsumptionDate(@RequestBody ConsumptionDto consumptionDto, @RequestHeader("userId") String id) {
        if (!Validator.validateConsumptionDto(consumptionDto))
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        groceriesService.addConsumptionDate(consumptionDto, Integer.parseInt(id));
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
