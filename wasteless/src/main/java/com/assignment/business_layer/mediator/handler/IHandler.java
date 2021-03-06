package com.assignment.business_layer.mediator.handler;

public interface IHandler<TRequest, TResponse> {

    TResponse handle(TRequest q);
}
