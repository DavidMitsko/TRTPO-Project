package com.mitsko.poputka.controller.impl;

import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.entity.Trip;
import com.mitsko.poputka.service.ServiceFactory;
import com.mitsko.poputka.service.TripService;

import java.util.List;

public class TripControllerImpl implements TripController {
    private final static TripControllerImpl instance = new TripControllerImpl();
    private Trip trip;

    private TripControllerImpl() {
    }

    public static TripControllerImpl getInstance() {
        return instance;
    }

    @Override
    public boolean addTrip(String pointOfDeparture, String destination
            , String data, String time, String comments) {

        String uid = UserControllerImpl.getInstance().getT().getId();

        Trip newTrip = new Trip(pointOfDeparture, destination, data, time, comments, uid);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TripService tripServiceImpl = serviceFactory.getTripServiceImpl();

        tripServiceImpl.addTrip(newTrip);

        return true;
    }

    @Override
    public boolean addTrip(String pointOfDeparture, String destination, String data, String time) {
        String uid = UserControllerImpl.getInstance().getT().getId();

        Trip newTrip = new Trip(pointOfDeparture, destination, data, time, uid);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TripService tripServiceImpl = serviceFactory.getTripServiceImpl();

        tripServiceImpl.addTrip(newTrip);

        return true;
    }

    @Override
    public List<Trip> takeAllTrips(String pointOfDeparture, String destination, String data, String time) {
        String uid = UserControllerImpl.getInstance().getT().getId();

        Trip newTrip = new Trip(pointOfDeparture, destination, data, time, uid);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TripService tripServiceImpl = serviceFactory.getTripServiceImpl();

        List<Trip> trips = tripServiceImpl.findTrips(newTrip);

        return trips;
    }

    @Override
    public boolean bookTrip(Trip trip) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TripService tripServiceImpl = serviceFactory.getTripServiceImpl();

        tripServiceImpl.bookTrip(trip);
        return true;
    }

    @Override
    public Trip getT() {
        return trip;
    }
}
