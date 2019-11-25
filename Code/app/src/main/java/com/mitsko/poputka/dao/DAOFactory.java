package com.mitsko.poputka.dao;

import com.mitsko.poputka.dao.impl.TripFirebaseDAOImpl;
import com.mitsko.poputka.dao.impl.UserFirebaseDAOImpl;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();

    private final UserDAO userDAOImpl = new UserFirebaseDAOImpl();
    private final TripDAO tripDAOImpl = new TripFirebaseDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAOImpl() {
        return userDAOImpl;
    }

    public TripDAO getTripDAOImpl() {
        return tripDAOImpl;
    }
}
