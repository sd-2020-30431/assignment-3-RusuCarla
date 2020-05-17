package com.assignment.business_layer.mediator.handler.commandHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.WeeklyReportCommand;
import com.assignment.business_layer.mediator.response.commandResponse.GenerateReportResponse;
import com.assignment.business_layer.services.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeeklyReportHandler implements IHandler<WeeklyReportCommand, GenerateReportResponse> {

    private final UserCommandService userCommandService;

    @Autowired
    public WeeklyReportHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @Override
    public GenerateReportResponse handle(WeeklyReportCommand c) {
        return new GenerateReportResponse(userCommandService.generateWeeklyReport(c.getExcess(),c.getId()));
    }
}
