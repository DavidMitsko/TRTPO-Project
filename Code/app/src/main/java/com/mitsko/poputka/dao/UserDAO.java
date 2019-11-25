package com.mitsko.poputka.dao;

import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;

public interface UserDAO {
    void addUser(User newUser, SignInInfo signInInfo);

    User getUser();

    void signInUser(SignInInfo signInInfo);

    void signOut();

    boolean isSignIn();
}
