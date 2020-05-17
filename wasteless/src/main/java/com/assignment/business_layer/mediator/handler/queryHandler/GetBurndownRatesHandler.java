package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.GetBurndownRatesQuery;
import com.assignment.business_layer.mediator.response.queryResponse.GetBurndownRatesResponse;
import com.assignment.business_layer.services.query.GroceriesQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetBurndownRatesHandler implements IHandler<GetBurndownRatesQuery, GetBurndownRatesResponse> {

    private final GroceriesQueryService groceriesQueryService;

    @Autowired
    public GetBurndownRatesHandler(GroceriesQueryService groceriesQueryService) {
        this.groceriesQueryService = groceriesQueryService;
    }

    @Override
    public GetBurndownRatesResponse handle(GetBurndownRatesQuery q) {
        return new GetBurndownRatesResponse(groceriesQueryService.getBurndownRates(q.getId()));
    }
}
