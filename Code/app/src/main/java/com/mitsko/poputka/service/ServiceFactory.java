package com.mitsko.poputka.service;

import com.mitsko.poputka.service.impl.TripServiceImpl;
import com.mitsko.poputka.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final UserService userServiceImpl = new UserServiceImpl();
    private final TripService tripServiceImpl = new TripServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }

    public TripService getTripServiceImpl() {
        return tripServiceImpl;
    }
}
