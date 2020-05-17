package com.assignment.business_layer.services.query;

import com.assignment.presentation_layer.dto.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.business_layer.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
