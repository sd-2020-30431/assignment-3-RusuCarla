package com.assignment.business_layer.report;

import com.assignment.business_layer.entity.Login;

public class GreenDecorator extends ReportDecorator {

    public GreenDecorator(Report report){
        super(report);
    }

    public String computeReport(Login login) {
        return greenDecorator() + super.computeReport(login);
    }

    private String greenDecorator() {
        return "Not wasting groceries! \n";
    }
}
