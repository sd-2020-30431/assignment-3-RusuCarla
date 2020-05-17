package com.assignment.business_layer.mediator;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.FindByIdHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.GetGroceriesHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LoginHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LogoutHandler;
import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.business_layer.mediator.request.query.FindByIdQuery;
import com.assignment.business_layer.mediator.request.query.GetGroceriesQuery;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.request.query.LogoutQuery;
import com.assignment.business_layer.mediator.response.TResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<Class<? extends TRequest>, Class<? extends IHandler<? extends TRequest, ? extends  TResponse>>> _handlerMap;

    public Mediator(){
        this._handlerMap = new HashMap<>();

        _handlerMap.put(LoginQuery.class, LoginHandler.class);
        _handlerMap.put(FindByIdQuery.class, FindByIdHandler.class);
        _handlerMap.put(LogoutQuery.class, LogoutHandler.class);
        _handlerMap.put(GetGroceriesQuery.class, GetGroceriesHandler.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T extends TRequest, R extends TResponse> IHandler<T, R> getHandler(T trequest){
        Class<? extends IHandler<? extends TRequest, ? extends TResponse>> specificHandler = _handlerMap.get(trequest.getClass());
        return (IHandler<T, R>) applicationContext.getBean(specificHandler);
    }
}
