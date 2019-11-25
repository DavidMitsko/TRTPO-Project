package com.mitsko.poputka.entity;

import java.util.Objects;

public class User {
    private Profile profile;
    private String id;

    public User(Profile profile, String id) {
        this.profile = profile;
        this.id = id;
    }

    public User() {
        profile = new Profile();
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return profile.equals(user.profile) && this.id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return profile.hashCode() + id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "profile=" + profile +
                ", id=" + id +
                '}';
    }
}
