package com.mitsko.poputka.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;

public class AddTripWindow extends Activity {

    private EditText pointOfDeparture;
    private EditText destination;
    private EditText dataDep;
    private EditText timeDep;
    private EditText comments;

    TripController tripController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_trip);

        pointOfDeparture = findViewById(R.id.textView0);
        destination = findViewById(R.id.destination);
        dataDep = findViewById(R.id.dataDep);
        timeDep = findViewById(R.id.timeDep);
        comments = findViewById(R.id.comments);

        tripController = TripControllerImpl.getInstance();
    }

    public void loadNewTrip(View view) {
        if (comments.getText().toString().equals("")) {
            tripController.addTrip(pointOfDeparture.getText().toString()
                    , destination.getText().toString()
                    , dataDep.getText().toString()
                    , timeDep.getText().toString());
        } else {
            tripController.addTrip(pointOfDeparture.getText().toString()
                    , destination.getText().toString()
                    , dataDep.getText().toString()
                    , timeDep.getText().toString()
                    , comments.getText().toString());
        }
    }
}
