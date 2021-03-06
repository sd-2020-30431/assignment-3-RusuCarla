package com.assignment.business_layer.mediator;

import com.assignment.business_layer.mediator.handler.IHandler;
import com.assignment.business_layer.mediator.handler.commandHandler.*;
import com.assignment.business_layer.mediator.handler.queryHandler.*;
import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.business_layer.mediator.request.command.*;
import com.assignment.business_layer.mediator.request.query.*;
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
        _handlerMap.put(GetBurndownRatesQuery.class, GetBurndownRatesHandler.class);

        _handlerMap.put(RegisterCommand.class, RegisterHandler.class);
        _handlerMap.put(SetGoalCommand.class, SetGoalHandler.class);
        _handlerMap.put(WeeklyReportCommand.class, WeeklyReportHandler.class);
        _handlerMap.put(MonthlyReportCommand.class, MonthlyReportHandler.class);
        _handlerMap.put(AddGroceriesCommand.class, AddGroceriesHandler.class);
        _handlerMap.put(AddConsumptionDateCommand.class, AddConsumptionDateHandler.class);
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
