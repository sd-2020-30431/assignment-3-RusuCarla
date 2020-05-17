package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.response.queryResponse.LoginQueryResponse;
import com.assignment.business_layer.services.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginQueryHandler implements IHandler<LoginQuery, LoginQueryResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public LoginQueryHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public LoginQueryResponse handle(LoginQuery q) {
        Integer integer = userQueryService.login(q.getLoginDto());
        return new LoginQueryResponse(integer);
    }
}
