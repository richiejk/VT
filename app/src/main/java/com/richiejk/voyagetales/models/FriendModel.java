package com.richiejk.voyagetales.models;

import java.util.ArrayList;

/**
 * Created by richie on 2/3/14.
 */
public class FriendModel {

    int user_id;
    String user_name;
    String email_id;
    String profile_picture;
    int trips_count;
    int status;
    int type;

    public FriendModel(int user_id, String user_name, String email_id, String profile_picture, int trips_count, int status, int type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email_id = email_id;
        this.profile_picture = profile_picture;
        this.trips_count = trips_count;
        this.status = status;
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public int getTrips_count() {
        return trips_count;
    }

    public void setTrips_count(int trips_count) {
        this.trips_count = trips_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
