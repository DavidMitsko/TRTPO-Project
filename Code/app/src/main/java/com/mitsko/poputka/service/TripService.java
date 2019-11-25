package com.mitsko.poputka.service;

import com.mitsko.poputka.entity.Trip;

import java.util.List;

public interface TripService {
    boolean addTrip(Trip trip);

    List<Trip> findTrips(Trip filter);

    List<Trip> takeAllUsersTrip(String uid);

    void bookTrip(Trip trip);
}