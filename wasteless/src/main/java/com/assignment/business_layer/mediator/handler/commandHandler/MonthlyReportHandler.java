package com.assignment.business_layer.mediator.handler.commandHandler;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.command.MonthlyReportCommand;
import com.assignment.business_layer.mediator.response.commandResponse.GenerateReportResponse;
import com.assignment.business_layer.services.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonthlyReportHandler implements IHandler<MonthlyReportCommand, GenerateReportResponse> {

    private final UserCommandService userCommandService;

    @Autowired
    public MonthlyReportHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @Override
    public GenerateReportResponse handle(MonthlyReportCommand c) {
        return new GenerateReportResponse(userCommandService.generateMonthlyReport(c.getExcess(),c.getId()));
    }
}
