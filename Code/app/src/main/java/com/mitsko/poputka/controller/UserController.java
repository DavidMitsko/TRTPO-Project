package com.mitsko.poputka.controller;

import android.net.Uri;

import com.mitsko.poputka.entity.User;

public interface UserController extends Controller<User> {
    void signIn(String email, String password);

    void createUser(String email, String password, String name, Uri photo);

    boolean isSignIn();

    void signOut();
}
