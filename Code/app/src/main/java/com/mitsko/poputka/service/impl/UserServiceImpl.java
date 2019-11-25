package com.mitsko.poputka.service.impl;

import com.mitsko.poputka.dao.DAOFactory;
import com.mitsko.poputka.dao.UserDAO;
import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;
import com.mitsko.poputka.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(User user, SignInInfo signInInfo) {
        if (user == null || signInInfo == null) {
            return false;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAOImpl();

        userDAO.addUser(user, signInInfo);
        return true;

        //free space
    }

    @Override
    public User getUser() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAOImpl();

        return userDAO.getUser();
    }

    @Override
    public boolean signIn(SignInInfo signInInfo) {
        if (signInInfo == null) {
            return false;
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAOImpl();

        userDAO.signInUser(signInInfo);
        return true;

        //free space
    }

    @Override
    public void signOut() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAOImpl();

        userDAO.signOut();
    }

    @Override
    public boolean isSignIn() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAOImpl();

        return userDAO.isSignIn();
    }
}
