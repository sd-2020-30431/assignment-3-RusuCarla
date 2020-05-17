package com.assignment.business_layer.mediator.handler.commandHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.RegisterCommand;
import com.assignment.business_layer.mediator.request.command.SetGoalCommand;
import com.assignment.business_layer.mediator.response.commandResponse.RegisterResponse;
import com.assignment.business_layer.mediator.response.commandResponse.SetGoalResponse;
import com.assignment.business_layer.services.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetGoalHandler implements IHandler<SetGoalCommand, SetGoalResponse> {

    private final UserCommandService userCommandService;

    @Autowired
    public SetGoalHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @Override
    public SetGoalResponse handle(SetGoalCommand c) {
        userCommandService.setGoal(c.getId(),c.getGoal());
        return new SetGoalResponse();
    }
}
