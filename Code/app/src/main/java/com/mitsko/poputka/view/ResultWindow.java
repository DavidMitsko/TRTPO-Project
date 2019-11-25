package com.mitsko.poputka.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;
import com.mitsko.poputka.entity.Trip;

import java.util.List;

public class ResultWindow extends Activity {
    private TripController tripController;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_window);

        tripController = TripControllerImpl.getInstance();
        listView = findViewById(R.id.result);
        /*ScrollView scrollView = findViewById(R.id.scrollView);
        LinearLayout scrollView1 = findViewById(R.id.result);
        //scrollView1.
        LinearLayout scrollView2 = //new ScrollView(scrollView.getContext());*/

        String pointOfDeparture = getIntent().getExtras().getString("point of departure");
        String destination = getIntent().getExtras().getString("destination");
        String data = getIntent().getExtras().getString("data");
        String time = getIntent().getExtras().getString("time");

        List<Trip> trips = tripController.takeAllTrips(pointOfDeparture, destination, data, time);

        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.item, trips);
        listView.setAdapter(itemAdapter);
    }


}
