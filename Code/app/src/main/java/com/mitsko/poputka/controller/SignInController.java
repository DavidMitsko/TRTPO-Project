package com.mitsko.poputka.controller;

import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;
import com.mitsko.poputka.service.ServiceFactory;
import com.mitsko.poputka.service.UserService;

public class SignInController {
    private final static SignInController instance = new SignInController();

    private SignInController() {
    }

    public static SignInController getInstance() {
        return instance;
    }

    public User signIn(String email, String password) {
        SignInInfo signInInfo = new SignInInfo(email, password);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        userService.signIn(signInInfo);
        return userService.getUser();
    }
}
