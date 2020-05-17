package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.FindByIdQuery;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.request.query.LogoutQuery;
import com.assignment.business_layer.mediator.response.queryResponse.FindByIdQueryResponse;
import com.assignment.business_layer.mediator.response.queryResponse.LoginQueryResponse;
import com.assignment.business_layer.mediator.response.queryResponse.LogoutQueryResponse;
import com.assignment.business_layer.services.query.UserQueryService;
import com.assignment.presentation_layer.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutQueryHandler implements IHandler<LogoutQuery, LogoutQueryResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public LogoutQueryHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public LogoutQueryResponse handle(LogoutQuery q) {
        userQueryService.logout(q.getId());
        return new LogoutQueryResponse();
    }
}
