package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.response.queryResponse.LoginResponse;
import com.assignment.business_layer.services.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler implements IHandler<LoginQuery, LoginResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public LoginHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public LoginResponse handle(LoginQuery q) {
        Integer integer = userQueryService.login(q.getLoginDto());
        return new LoginResponse(integer);
    }
}
