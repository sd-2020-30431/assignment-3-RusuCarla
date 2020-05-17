package com.assignment.business_layer.mediator.request.command;

import com.assignment.business_layer.mediator.request.TRequest;
import com.assignment.presentation_layer.dto.LoginDto;

public class RegisterCommand implements TRequest {
    LoginDto loginDto;

    public RegisterCommand(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

    public LoginDto getLoginDto() {
        return loginDto;
    }

    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }
}
