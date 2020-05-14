package com.assignment.business_layer.report;

import com.assignment.business_layer.entity.Login;

public class ReportDecorator implements Report {
    private Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public String computeReport(Login login) {
        return report.computeReport(login);
    }
}
