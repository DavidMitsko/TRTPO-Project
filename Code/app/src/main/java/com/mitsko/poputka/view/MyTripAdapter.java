package com.mitsko.poputka.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;
import com.mitsko.poputka.entity.Trip;

import java.util.List;

public class MyTripAdapter extends ArrayAdapter<Trip> {
    private LayoutInflater inflater;
    private int layout;
    private List<Trip> trips;
    TripController tripController;

    MyTripAdapter(Context context, int resource, List<Trip> trips) {
        super(context, resource, trips);
        this.trips = trips;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        tripController = TripControllerImpl.getInstance();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final MyTripAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new MyTripAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyTripAdapter.ViewHolder) convertView.getTag();
        }
        final Trip trip = trips.get(position);

        viewHolder.pointOfDeparture.setText(trip.getPointOfDeparture());
        viewHolder.destination.setText(trip.getDestination());
        viewHolder.data.setText(trip.getData());
        viewHolder.time.setText(trip.getTime());
        if (trip.isOrder()) {
            viewHolder.order.setText("true");
        } else {
            viewHolder.order.setText("false");
        }
        if (trip.getComments() != null) {
            viewHolder.comments.setText(trip.getComments());
        }

        return convertView;
    }

    private class ViewHolder {
        private final TextView pointOfDeparture, destination, data, time, comments, order;

        ViewHolder(View view) {
            order = view.findViewById(R.id.order);
            pointOfDeparture = view.findViewById(R.id.textView17);
            destination = view.findViewById(R.id.textView23);
            data = view.findViewById(R.id.textView25);
            time = view.findViewById(R.id.textView26);
            comments = view.findViewById(R.id.textView27);
        }
    }
}
