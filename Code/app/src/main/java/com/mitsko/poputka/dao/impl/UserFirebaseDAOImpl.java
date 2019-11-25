package com.mitsko.poputka.dao.impl;

import android.app.Activity;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.mitsko.poputka.dao.UserDAO;
import com.mitsko.poputka.entity.SignInInfo;
import com.mitsko.poputka.entity.User;

public class UserFirebaseDAOImpl extends Activity implements UserDAO {

    private FirebaseAuth mAuth;
    User signInUser = new User();

    public UserFirebaseDAOImpl() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void addUser(final User newUser, SignInInfo signInInfo) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(signInInfo.getEmail(), signInInfo.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            signInProfile(newUser);
                        }
                    }
                });
    }

    @Override
    public void signInUser(SignInInfo signInInfo) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return;
        }

        mAuth.signInWithEmailAndPassword(signInInfo.getEmail(), signInInfo.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            signInUser.getProfile().setName(user.getDisplayName());
                            signInUser.getProfile().setPhoto(user.getPhotoUrl());

                        }
                    }
                });
    }

    @Override
    public void signOut() {
        mAuth.signOut();
    }

    @Override
    public boolean isSignIn() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            return null;
        }
        signInUser.getProfile().setName(currentUser.getDisplayName());
        signInUser.getProfile().setPhoto(currentUser.getPhotoUrl());
        signInUser.setId(currentUser.getUid());

        return signInUser;
    }

    private void signInProfile(User newUser) {
        if (newUser.getProfile().getPhoto() == null) {
            signInProfileWithoutPhoto(newUser.getProfile().getName());
        } else {
            signInProfileWithPhoto(newUser.getProfile().getName(), newUser.getProfile().getPhoto());
        }
    }

    private void signInProfileWithoutPhoto(String name) {
        FirebaseUser user = mAuth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        user.updateProfile(profileUpdates);
                /*.addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        /*if (task.isSuccessful()) {

                        }
                    }
                });*/
    }

    private void signInProfileWithPhoto(String name, Uri photo) {
        FirebaseUser user = mAuth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(photo)
                .build();
        user.updateProfile(profileUpdates);
                /*.addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                        }
                    }
                });*/
    }
}
