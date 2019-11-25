package com.mitsko.poputka.controller;

import com.mitsko.poputka.entity.Trip;

import java.util.List;

public interface TripController extends Controller<Trip> {
    boolean addTrip(String pointOfDeparture, String destination, String data, String time);

    boolean addTrip(String pointOfDeparture, String destination, String data, String time, String comments);

    List<Trip> takeAllTrips(String pointOfDeparture, String destination, String data, String time);

    boolean bookTrip(Trip trip);

}
