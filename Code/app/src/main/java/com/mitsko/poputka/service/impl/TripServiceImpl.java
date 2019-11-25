package com.mitsko.poputka.service.impl;

import com.mitsko.poputka.dao.DAOFactory;
import com.mitsko.poputka.dao.TripDAO;
import com.mitsko.poputka.entity.Trip;
import com.mitsko.poputka.service.TripService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripServiceImpl implements TripService {
    @Override
    public boolean addTrip(Trip trip) {
        if (trip == null) {
            return false;
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        TripDAO tripDAOImpl = daoFactory.getTripDAOImpl();

        tripDAOImpl.addTrip(trip);
        return true;
    }

    @Override
    public List<Trip> findTrips(Trip filter) {
        if (filter == null) {
            return null;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        TripDAO tripDAOImpl = daoFactory.getTripDAOImpl();

        //List<Trip> trips = (List<Trip>)tripDAOImpl.takeAllTrips().values();
        Map<String, Trip> map = tripDAOImpl.takeAllTrips();
        Set<Map.Entry<String, Trip>> set = map.entrySet();
        List<Trip> trips = new ArrayList<>();

        for (Map.Entry<String, Trip> trip : set) {
            trips.add(trip.getValue());
        }
        trips = findTripsByParam(trips, filter);
        return trips;
    }

    @Override
    public List<Trip> takeAllUsersTrip(String uid) {
        if (uid == null) {
            return null;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        TripDAO tripDAOImpl = daoFactory.getTripDAOImpl();

        List<Trip> trips = (List<Trip>) tripDAOImpl.takeAllTrips().values();
        trips = findTripsByUid(trips, uid);

        return trips;
    }

    @Override
    public void bookTrip(Trip trip) {
        if (trip == null) {
            return;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        TripDAO tripDAOImpl = daoFactory.getTripDAOImpl();

        Map<String, Trip> trips = tripDAOImpl.takeAllTrips();
        Set<Map.Entry<String, Trip>> set = trips.entrySet();

        String docId = findTripsByParam(set, trip);

        tripDAOImpl.updateOrder(docId);
    }

    private List<Trip> findTripsByUid(List<Trip> trips, String filter) {
        List<Trip> retTrips = new ArrayList<>();

        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getUid().equals(filter)) {
                retTrips.add(trips.get(i));
            }
        }

        return retTrips;
    }

    private List<Trip> findTripsByParam(List<Trip> trips, Trip filter) {
        List<Trip> retTrips = new ArrayList<>();

        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getUid().equals(filter.getUid())) {
                continue;
            }
            if (trips.get(i).getPointOfDeparture().equals(filter.getPointOfDeparture())
                    && trips.get(i).getDestination().equals(filter.getDestination())
                    && trips.get(i).getData().equals(filter.getData())
                    && trips.get(i).getTime().equals(filter.getTime())) {
                retTrips.add(trips.get(i));
            }
        }

        return retTrips;
    }

    private String findTripsByParam(Set<Map.Entry<String, Trip>> trips, Trip filter) {
        for (Map.Entry<String, Trip> trip : trips) {
            if (trip.getValue().equals(filter)) {
                return trip.getKey();
            }
        }
        return null;
    }
}
