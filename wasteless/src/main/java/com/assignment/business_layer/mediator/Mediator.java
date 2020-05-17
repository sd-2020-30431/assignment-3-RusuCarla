package com.assignment.business_layer.mediator;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.FindByIdQueryHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LoginQueryHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LogoutQueryHandler;
import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.business_layer.mediator.request.query.FindByIdQuery;
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

        _handlerMap.put(LoginQuery.class, LoginQueryHandler.class);
        _handlerMap.put(FindByIdQuery.class, FindByIdQueryHandler.class);
        _handlerMap.put(LogoutQuery.class, LogoutQueryHandler.class);
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
