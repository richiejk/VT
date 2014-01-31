package com.richiejk.voyagetales.models;

import java.util.ArrayList;

/**
 * Created by richie on 1/31/14.
 */
public class UserModel {

    int user_id;
    String user_name;
    String email_id;
    String profile_picture;
    ArrayList<UserModel> friends;
    int friends_count;
    int messages_count;
    int trips_count;
    int status;
    int type;

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

    public int getTrips_count() {
        return trips_count;
    }

    public void setTrips_count(int trips_count) {
        this.trips_count = trips_count;
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

    public ArrayList<UserModel> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<UserModel> friends) {
        this.friends = friends;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public int getMessages_count() {
        return messages_count;
    }

    public void setMessages_count(int messages_count) {
        this.messages_count = messages_count;
    }

    public UserModel(int user_id, String user_name, String email_id, String profile_picture, ArrayList<UserModel> friends, int friends_count, int messages_count, int trips_count, int status, int type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email_id = email_id;
        this.profile_picture = profile_picture;
        this.friends = friends;
        this.friends_count = friends_count;
        this.messages_count = messages_count;
        this.trips_count = trips_count;
        this.status = status;
        this.type = type;
    }

    public UserModel(int user_id, String user_name, String email_id, String profile_picture, int friends_count, int messages_count, int trips_count, int status, int type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.email_id = email_id;
        this.profile_picture = profile_picture;
        this.friends_count = friends_count;
        this.messages_count = messages_count;
        this.trips_count = trips_count;
        this.status = status;
        this.type = type;
    }

    public UserModel() {
    }
}
