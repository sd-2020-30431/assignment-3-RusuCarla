package com.assignment.business_layer.mediator.handler.queryHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.RegisterCommand;
import com.assignment.business_layer.mediator.response.commandResponse.RegisterResponse;
import com.assignment.business_layer.services.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler implements IHandler<RegisterCommand, RegisterResponse> {

    private final UserCommandService userCommandService;

    @Autowired
    public RegisterHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @Override
    public RegisterResponse handle(RegisterCommand c) {
        return new RegisterResponse(userCommandService.register(c.getLoginDto()));
    }
}
