package com.assignment.business_layer.mediator;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.request.TRequest;

import java.util.HashMap;
import java.util.Map;

public class Mediator {

    private final Map<TRequest, IHandler> _handlerMap;

    public Mediator(){
        this._handlerMap = new HashMap<>();
    }
}
