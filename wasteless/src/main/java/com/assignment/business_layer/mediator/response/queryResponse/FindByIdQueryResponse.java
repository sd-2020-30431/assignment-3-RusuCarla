package com.assignment.business_layer.mediator.response.queryResponse;

import com.assignment.business_layer.mediator.response.TResponse;
import com.assignment.presentation_layer.dto.LoginDto;

public class FindByIdQueryResponse implements TResponse {

    LoginDto loginDto;

    public FindByIdQueryResponse(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

    public LoginDto getLoginDto() {
        return loginDto;
    }

    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }
}
