package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.FindByIdQuery;
import com.assignment.business_layer.mediator.response.queryResponse.FindByIdResponse;
import com.assignment.business_layer.services.query.UserQueryService;
import com.assignment.presentation_layer.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindByIdHandler implements IHandler<FindByIdQuery, FindByIdResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public FindByIdHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public FindByIdResponse handle(FindByIdQuery q) {
        LoginDto loginDto = userQueryService.findById(q.getId());
        return new FindByIdResponse(loginDto);
    }
}
