package com.assignment.business_layer.services.query;

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
public class UserQueryService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;

    public Integer login(LoginDto loginDto) {
        Login login = loginRepository.findByUsername(loginDto.getUsername());
        if (login != null)
            if (login.getPassword().equals(loginDto.getPassword()))
                return login.getId();
        return null;
    }

    public void logout(Integer id) {
    }

    public LoginDto findById(int id) {
        Login login = loginRepository.findById(id);
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        loginDto.setGoal(login.getGoal());
        return loginDto;
    }
}
