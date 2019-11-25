package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.controller.impl.UserControllerImpl;
import com.mitsko.poputka.dao.TripDAO;
import com.mitsko.poputka.dao.impl.TripFirebaseDAOImpl;
import com.mitsko.poputka.entity.Trip;

import java.util.List;

public class MenuWindow extends Activity {

    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_window);

        userController = UserControllerImpl.getInstance();

        /*Button find = findViewById(R.id.button9);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuWindow.this, ListWindow.class);
                startActivity(intent);
            }
        });*/
    }

    public void findTrip(View view) {


        /*TripDAO tripDAO = new TripFirebaseDAOImpl();
        Trip trip = tripDAO.takeTrip(null);*/

        Intent intent = new Intent(MenuWindow.this, FindTripWindow.class);
        startActivity(intent);
        //setContentView(R.layout.list_view);

        /*ListView listView = findViewById(R.id.list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getBaseContext()
                , android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);*/
    }

    public void load(View view) {
        /*TripDAO tripDAO = new TripFirebaseDAOImpl();
        tripDAO.addTrip(new Trip("Minsk", "Moskau", "12.12", "15.45", "0"));*/
        Intent intent = new Intent(MenuWindow.this, AddTripWindow.class);
        startActivity(intent);
    }

    public void exit(View view) {
        userController.signOut();
        finish();
    }
}
