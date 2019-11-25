package com.mitsko.poputka.service;

import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;

public interface UserService {
    boolean addUser(User user, SignInInfo signInInfo);

    User getUser();

    boolean signIn(SignInInfo signInInfo);

    void signOut();

    boolean isSignIn();
}
