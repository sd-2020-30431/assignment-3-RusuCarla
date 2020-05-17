package com.assignment.business_layer.mediator.request.command;

import com.assignment.business_layer.mediator.request.TRequest;

public class MonthlyReportCommand implements TRequest {

    int excess;
    int id;

    public MonthlyReportCommand(int excess, int id) {
        this.excess = excess;
        this.id = id;
    }

    public int getExcess() {
        return excess;
    }

    public void setExcess(int excess) {
        this.excess = excess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
