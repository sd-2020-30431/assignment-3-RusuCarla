package com.assignment.business_layer.mediator.request.query;

import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.presentation_layer.dto.LoginDto;
import org.springframework.stereotype.Component;

public class LoginQuery implements TRequest {

    LoginDto loginDto;

    public LoginQuery(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

    public LoginDto getLoginDto() {
        return loginDto;
    }

    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }
}
