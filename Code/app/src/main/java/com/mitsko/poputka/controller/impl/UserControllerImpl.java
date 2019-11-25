package com.mitsko.poputka.controller.impl;

import android.net.Uri;

import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;
import com.mitsko.poputka.service.ServiceFactory;
import com.mitsko.poputka.service.UserService;

public class UserControllerImpl implements UserController {

    private final static UserControllerImpl instance = new UserControllerImpl();
    private User user;

    public static UserControllerImpl getInstance() {
        return instance;
    }

    private UserControllerImpl() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        user = userService.getUser();
    }

    @Override
    public void signIn(String email, String password) {
        SignInInfo signInInfo = new SignInInfo(email, password);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        userService.signIn(signInInfo);
        user = userService.getUser();
    }

    @Override
    public void createUser(String email, String password, String name, Uri photo) {
        if (user == null) {
            user = new User();
        }
        user.getProfile().setPhoto(photo);
        user.getProfile().setName(name);

        SignInInfo signInInfo = new SignInInfo(email, password);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        userService.addUser(user, signInInfo);
    }

    @Override
    public boolean isSignIn() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        return userService.isSignIn();
    }

    @Override
    public void signOut() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserServiceImpl();

        userService.signOut();
    }

    @Override
    public User getT() {
        return user;
    }
}
