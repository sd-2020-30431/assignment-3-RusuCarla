package com.assignment.business_layer.mediator.request.command;

import com.assignment.business_layer.mediator.request.TRequest;

public class SetGoalCommand implements TRequest {
    int id;
    int goal;

    public SetGoalCommand(int id, int goal) {
        this.id = id;
        this.goal = goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
