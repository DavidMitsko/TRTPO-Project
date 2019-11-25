package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;

public class FindTripWindow extends Activity {
    private TripController tripController;

    private EditText pointOfDepart;
    private EditText destination;
    private EditText dataDep;
    private EditText timeDep;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_window);

        pointOfDepart = findViewById(R.id.pointOfDeparture);
        destination = findViewById(R.id.destination);
        dataDep = findViewById(R.id.dataDep);
        timeDep = findViewById(R.id.timeDep);

        tripController = TripControllerImpl.getInstance();
    }

    public void find(View view) {
        Intent intent = new Intent(FindTripWindow.this, ResultWindow.class);
        intent.putExtra("point of departure", pointOfDepart.getText().toString());
        intent.putExtra("destination", destination.getText().toString());
        intent.putExtra("data", dataDep.getText().toString());
        intent.putExtra("time", timeDep.getText().toString());
        startActivity(intent);
    }
}
