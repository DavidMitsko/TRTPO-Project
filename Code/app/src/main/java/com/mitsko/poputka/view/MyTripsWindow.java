package com.mitsko.poputka.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;
import com.mitsko.poputka.entity.Trip;

import java.util.List;

public class MyTripsWindow extends Activity {
    private TripController tripController;
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_window);

        tripController = TripControllerImpl.getInstance();
        listView = findViewById(R.id.result);

        List<Trip> trips = tripController.takeAllUsersTrip();

        MyTripAdapter itemAdapter = new MyTripAdapter(this, R.layout.my_trip_item, trips);
        listView.setAdapter(itemAdapter);
    }
}
