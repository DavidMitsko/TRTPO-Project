package com.mitsko.poputka.dao.impl;

import android.widget.HeaderViewListAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mitsko.poputka.R;
import com.mitsko.poputka.dao.TripDAO;
import com.mitsko.poputka.entity.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripFirebaseDAOImpl extends AppCompatActivity implements TripDAO {

    private static final String KEY_ORDER = "order";

    private List<Trip> trips;
    private Map<String, Trip> map = new HashMap<>();


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference tripsRef = db.collection("Trips");

    @Override
    public void addTrip(Trip trip) {
        tripsRef.add(trip);
    }

    @Override
    public Map<String, Trip> takeAllTrips() {
        tripsRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Map<String, Trip> newMapTrip = new HashMap<>();
                        String docId;
                        Trip newTrip;

                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                            //newListTrip.add(documentSnapshot.toObject(Trip.class));
                            newTrip = documentSnapshot.toObject(Trip.class);
                            docId = documentSnapshot.getId();

                            newMapTrip.put(docId, newTrip);
                        }
                        update(newMapTrip);
                        Toast.makeText(getApplicationContext(), "Чтение из БД", Toast.LENGTH_LONG).show();
                    }
                });
        return map;
    }

    @Override
    public void updateOrder(String docId) {
        boolean order = true;

        tripsRef.document(docId).update(KEY_ORDER, order);
    }

    private void update(Map<String, Trip> newTrips) {
        this.map = new HashMap<>(newTrips);
        //this.map.put("0", new Trip("Minsk", "Moskau"
        //, "12.12", "15.45", "0"));
    }
}
