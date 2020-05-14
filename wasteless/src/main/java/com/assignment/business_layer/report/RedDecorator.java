package com.assignment.business_layer.report;

import com.assignment.business_layer.entity.Login;

public class RedDecorator extends ReportDecorator {

    public RedDecorator(Report report){
        super(report);
    }

    public String computeReport(Login login) {
        return redDecorator() + super.computeReport(login);
    }

    private String redDecorator() {
        return "Wasting groceries! \n";
    }
}
