package com.mitsko.poputka.entity;

public class Trip {
    private String pointOfDeparture;
    private String destination;
    private String data;
    private String time;
    private String comments;
    private String uid;
    private boolean order;

    public Trip() {
    }

    public Trip(String pointOfDeparture, String destination, String data, String time, String uid) {
        this.pointOfDeparture = pointOfDeparture;
        this.destination = destination;
        this.data = data;
        this.time = time;
        this.uid = uid;
        this.order = false;
    }

    public Trip(String pointOfDeparture, String destination, String data
            , String time, String comments, String uid) {
        this.pointOfDeparture = pointOfDeparture;
        this.destination = destination;
        this.data = data;
        this.time = time;
        this.comments = comments;
        this.uid = uid;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPointOfDeparture() {
        return pointOfDeparture;
    }

    public void setPointOfDeparture(String pointOfDeparture) {
        this.pointOfDeparture = pointOfDeparture;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return pointOfDeparture.equals(trip.pointOfDeparture) &&
                destination.equals(trip.destination) &&
                data.equals(trip.data) &&
                time.equals(trip.time) &&
                comments.equals(trip.comments) &&
                this.uid.equals(trip.uid) &&
                this.order == trip.order;
    }

    @Override
    public int hashCode() {
        int hash = pointOfDeparture.hashCode() + destination.hashCode() + data.hashCode() + time.hashCode()
                + uid.hashCode();
        if (comments != null) {
            hash += comments.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "pointOfDeparture='" + pointOfDeparture + '\'' +
                ", destination='" + destination + '\'' +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", comments='" + comments + '\'' +
                ", uid='" + uid + '\'' +
                ", order=" + order +
                '}';
    }
}
