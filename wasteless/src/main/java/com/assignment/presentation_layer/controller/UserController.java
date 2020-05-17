package com.assignment.presentation_layer.controller;

import com.assignment.business_layer.mediator.Mediator;
import com.assignment.business_layer.mediator.handler.queryHandler.FindByIdQueryHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LoginQueryHandler;
import com.assignment.business_layer.mediator.handler.queryHandler.LogoutQueryHandler;
import com.assignment.business_layer.mediator.request.query.FindByIdQuery;
import com.assignment.business_layer.mediator.request.query.LoginQuery;
import com.assignment.business_layer.mediator.request.query.LogoutQuery;
import com.assignment.business_layer.mediator.response.queryResponse.FindByIdQueryResponse;
import com.assignment.business_layer.mediator.response.queryResponse.LoginQueryResponse;
import com.assignment.business_layer.mediator.response.queryResponse.LogoutQueryResponse;
import com.assignment.presentation_layer.dto.*;
import com.assignment.business_layer.services.UserService;
import com.assignment.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/register")
    public ResponseEntity<StringObj> register(@RequestBody LoginDto loginDto) {
        if (Validator.validateLoginDto(loginDto)) {
            System.out.println(loginDto);
            switch (userService.register(loginDto)) {
                case 0:
                    return new ResponseEntity<>(new StringObj("SUCCESS : USER REGISTERED"), HttpStatus.OK);
                case -1:
                    return new ResponseEntity<>(new StringObj("ERROR: DUPLICATE USERNAME"), HttpStatus.CONFLICT);
                default:
                    return new ResponseEntity<>(new StringObj("ERROR: UNKNOWN"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Integer> login(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        if (!Validator.validateLoginDto(loginDto))
            return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);
        //Integer id = userService.login(loginDto);

        LoginQuery loginQuery = new LoginQuery(loginDto);
        LoginQueryHandler loginQueryHandler = (LoginQueryHandler) mediator.<LoginQuery, LoginQueryResponse>getHandler(loginQuery);
        LoginQueryResponse loginQueryResponse = loginQueryHandler.handle(loginQuery);
        Integer id = loginQueryResponse.getInteger();

        if (id == null)
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> logout(@RequestHeader("id") Integer id) {
        //userService.logout(id);

        LogoutQuery logoutQuery = new LogoutQuery(id);
        LogoutQueryHandler logoutQueryHandler = (LogoutQueryHandler)mediator.<LogoutQuery, LogoutQueryResponse>getHandler(logoutQuery);
        LogoutQueryResponse logoutQueryResponse = logoutQueryHandler.handle(logoutQuery);

        return new ResponseEntity<>("SUCCESS: LOGGED OUT", HttpStatus.OK);
    }

    @PostMapping(value = "/setGoal")
    public ResponseEntity addConsumptionDate(@RequestBody Integer goal, @RequestHeader("userId") String id) {
        if (!Validator.validateGoal(goal))
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        userService.setGoal(Integer.parseInt(id), goal);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/getGoal")
    public ResponseEntity<LoginDto> getGoal(@RequestHeader("userId") String id) {
        //LoginDto loginDto = userService.findById(Integer.parseInt(id));

        FindByIdQuery findByIdQuery = new FindByIdQuery(Integer.parseInt(id));
        FindByIdQueryHandler findByIdQueryHandler = (FindByIdQueryHandler) mediator.<FindByIdQuery, FindByIdQueryResponse>getHandler(findByIdQuery);
        FindByIdQueryResponse findByIdQueryResponse = findByIdQueryHandler.handle(findByIdQuery);
        LoginDto loginDto = findByIdQueryResponse.getLoginDto();

        return new ResponseEntity(loginDto, HttpStatus.OK);
    }

    @PostMapping(value = "/weeklyReport")
    public ResponseEntity<StringObj> weeklyReport(@RequestBody Integer excess, @RequestHeader("userId") String id) {
        StringObj stringObj = userService.generateWeeklyReport(excess, Integer.parseInt(id));
        return new ResponseEntity(stringObj, HttpStatus.OK);
    }

    @PostMapping(value = "/monthlyReport")
    public ResponseEntity<StringObj> monthlyReport(@RequestBody Integer excess, @RequestHeader("userId") String id) {
        StringObj stringObj = userService.generateMonthlyReport(excess, Integer.parseInt(id));
        return new ResponseEntity(stringObj, HttpStatus.OK);
    }
}
