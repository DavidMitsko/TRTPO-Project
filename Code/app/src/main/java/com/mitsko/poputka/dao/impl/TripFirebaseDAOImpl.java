package com.mitsko.poputka.dao.impl;

import android.app.Activity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mitsko.poputka.dao.TripDAO;
import com.mitsko.poputka.entity.Trip;

import java.util.HashMap;
import java.util.Map;

public class TripFirebaseDAOImpl extends Activity implements TripDAO {

    private static final String KEY_ORDER = "order";

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

                            newTrip = documentSnapshot.toObject(Trip.class);
                            docId = documentSnapshot.getId();

                            newMapTrip.put(docId, newTrip);
                        }
                        update(newMapTrip);
                    }
                });
        map.put("0", new Trip("Brest", "Minsk", "12.02.2019", "15:00", "0123"));
        map.put("1", new Trip("Brest", "Minsk", "12.02.2019", "15:00", "4567"));

        return map;
    }

    @Override
    public void updateOrder(String docId) {
        boolean order = true;

        tripsRef.document(docId).update(KEY_ORDER, order);
    }

    private void update(Map<String, Trip> newTrips) {
        this.map = new HashMap<>(newTrips);
    }
}
