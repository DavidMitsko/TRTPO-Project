package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.controller.impl.UserControllerImpl;

public class MenuWindow extends Activity {

    UserController userController; //access modifier is lost

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_window);

        userController = UserControllerImpl.getInstance();
    }

    public void findTrip(View view) {
        Intent intent = new Intent(MenuWindow.this, FindTripWindow.class);
        startActivity(intent);
    }

    public void load(View view) {
        Intent intent = new Intent(MenuWindow.this, AddTripWindow.class);
        startActivity(intent);
    }

    public void myTrips(View view) {
        Intent intent = new Intent(MenuWindow.this, MyTripsWindow.class);
        startActivity(intent);
    }

    public void exit(View view) {
        userController.signOut();
        finish();
    }
}
