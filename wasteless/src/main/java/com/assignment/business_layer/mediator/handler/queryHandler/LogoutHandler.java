package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.LogoutQuery;
import com.assignment.business_layer.mediator.response.queryResponse.LogoutResponse;
import com.assignment.business_layer.services.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutHandler implements IHandler<LogoutQuery, LogoutResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public LogoutHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public LogoutResponse handle(LogoutQuery q) {
        userQueryService.logout(q.getId());
        return new LogoutResponse();
    }
}
