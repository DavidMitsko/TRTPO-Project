package com.mitsko.poputka.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.TripController;
import com.mitsko.poputka.controller.impl.TripControllerImpl;
import com.mitsko.poputka.entity.Trip;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Trip> {
    private LayoutInflater inflater;
    private int layout;
    private List<Trip> trips;
    TripController tripController; //access modifier is lost

    ItemAdapter(Context context, int resource, List<Trip> trips) {
        super(context, resource, trips);
        this.trips = trips;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        tripController = TripControllerImpl.getInstance();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Trip trip = trips.get(position);

        viewHolder.pointOfDeparture.setText(trip.getPointOfDeparture());
        viewHolder.destination.setText(trip.getDestination());
        viewHolder.data.setText(trip.getData());
        viewHolder.time.setText(trip.getTime());
        if (trip.getComments() != null) {
            viewHolder.comments.setText(trip.getComments());
        }

        viewHolder.bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tripController.bookTrip(trip);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        private final Button bookButton;
        private final TextView pointOfDeparture, destination, data, time, comments;

        ViewHolder(View view) {
            bookButton = view.findViewById(R.id.button14);
            pointOfDeparture = view.findViewById(R.id.textView17);
            destination = view.findViewById(R.id.textView23);
            data = view.findViewById(R.id.textView25);
            time = view.findViewById(R.id.textView26);
            comments = view.findViewById(R.id.textView27);
        }
    }
}
