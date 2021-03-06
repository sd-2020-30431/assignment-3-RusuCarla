package com.assignment.business_layer.services.command;

import com.assignment.business_layer.report.GreenDecorator;
import com.assignment.business_layer.report.RedDecorator;
import com.assignment.presentation_layer.dto.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.business_layer.entity.Login;
import com.assignment.business_layer.factory.AbstractFactory;
import com.assignment.business_layer.factory.FactoryProvider;
import com.assignment.business_layer.report.Report;
import com.assignment.business_layer.report.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserCommandService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;


    @Transactional
    public int register(LoginDto loginDto) {
        if (loginRepository.findByUsername(loginDto.getUsername()) != null)
            return -1;

        Login login = new Login();
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        loginRepository.save(login);
        return 0;
    }

    @Transactional
    public void setGoal(int id, int goal){
        Login login = loginRepository.findById(id);
        login.setGoal(goal);
        loginRepository.save(login);
    }

    @Transactional
    public StringObj generateWeeklyReport(int excess, int id){
        Login login = loginRepository.findById(id);
        AbstractFactory abstractFactory = FactoryProvider.getFactory(ReportType.WEEKLY);

        Report report;
        if (excess==1)
            report =  new RedDecorator(abstractFactory.getReport(ReportType.WEEKLY));
        else
            report =  new GreenDecorator(abstractFactory.getReport(ReportType.WEEKLY));

        StringObj stringObj = new StringObj(report.computeReport(login));
        return stringObj;
    }

    @Transactional
    public StringObj generateMonthlyReport(int excess, int id){
        Login login = loginRepository.findById(id);
        AbstractFactory abstractFactory = FactoryProvider.getFactory(ReportType.MONTHLY);

        Report report;
        if (excess==1)
            report =  new RedDecorator(abstractFactory.getReport(ReportType.MONTHLY));
        else
            report =  new GreenDecorator(abstractFactory.getReport(ReportType.MONTHLY));

        StringObj stringObj = new StringObj(report.computeReport(login));
        return stringObj;
    }


}
