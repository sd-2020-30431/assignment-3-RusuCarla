package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.GetGroceriesQuery;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.response.queryResponse.GetGroceriesResponse;
import com.assignment.business_layer.mediator.response.queryResponse.LoginResponse;
import com.assignment.business_layer.services.query.GroceriesQueryService;
import com.assignment.business_layer.services.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetGroceriesHandler implements IHandler<GetGroceriesQuery, GetGroceriesResponse> {

    private final GroceriesQueryService groceriesQueryService;

    @Autowired
    public GetGroceriesHandler(GroceriesQueryService groceriesQueryService) {
        this.groceriesQueryService = groceriesQueryService;
    }

    @Override
    public GetGroceriesResponse handle(GetGroceriesQuery q) {
        return new GetGroceriesResponse(groceriesQueryService.getGroceries(q.getId()));
    }
}
