package com.mitsko.poputka.entity;

import android.net.Uri;

public class Profile {
    private Uri photo;
    private String name;
    private String phoneNumber;

    public Profile(Uri photo, String name, String phoneNumber) {
        this.photo = photo;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Profile(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Profile(String name) {
        this.name = name;
    }

    public Profile() {
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return photo.equals(profile.photo) &&
                name.equals(profile.name) &&
                phoneNumber.equals(profile.phoneNumber);
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode() + phoneNumber.hashCode();
        if (photo != null) {
            hash += photo.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "photo=" + photo +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
