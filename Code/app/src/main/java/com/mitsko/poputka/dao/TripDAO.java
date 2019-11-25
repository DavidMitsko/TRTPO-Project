package com.mitsko.poputka.dao;

import com.mitsko.poputka.entity.Trip;

import java.util.List;
import java.util.Map;

public interface TripDAO {
    void addTrip(Trip trip);

    Map<String, Trip> takeAllTrips();

    void updateOrder(String docId);
}
