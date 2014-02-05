package com.richiejk.voyagetales.models;

import java.util.ArrayList;

/**
 * Created by richie on 2/5/14.
 */
public class TripModel {

    String trip_name;
    int trip_id;
    String trip_description;
    int trip_status;
    String trip_start_date;
    String trip_end_date;
    int fans_count;
    String rating;
    ArrayList<FriendModel> collaborators;
    boolean isDownloaded;
    String trip_cover_picture;

    public String getTrip_cover_picture() {
        return trip_cover_picture;
    }

    public void setTrip_cover_picture(String trip_cover_picture) {
        this.trip_cover_picture = trip_cover_picture;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_description() {
        return trip_description;
    }

    public void setTrip_description(String trip_description) {
        this.trip_description = trip_description;
    }

    public int getTrip_status() {
        return trip_status;
    }

    public void setTrip_status(int trip_status) {
        this.trip_status = trip_status;
    }

    public String getTrip_start_date() {
        return trip_start_date;
    }

    public void setTrip_start_date(String trip_start_date) {
        this.trip_start_date = trip_start_date;
    }

    public String getTrip_end_date() {
        return trip_end_date;
    }

    public void setTrip_end_date(String trip_end_date) {
        this.trip_end_date = trip_end_date;
    }

    public int getFans_count() {
        return fans_count;
    }

    public void setFans_count(int fans_count) {
        this.fans_count = fans_count;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<FriendModel> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<FriendModel> collaborators) {
        this.collaborators = collaborators;
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean isDownloaded) {
        this.isDownloaded = isDownloaded;
    }

    public TripModel(String trip_name, int trip_id, String trip_description, int trip_status, String trip_start_date, String trip_end_date, int fans_count, String rating, ArrayList<FriendModel> collaborators, boolean isDownloaded, String trip_cover_picture) {
        this.trip_name = trip_name;
        this.trip_id = trip_id;
        this.trip_description = trip_description;
        this.trip_status = trip_status;
        this.trip_start_date = trip_start_date;
        this.trip_end_date = trip_end_date;
        this.fans_count = fans_count;
        this.rating = rating;
        this.collaborators = collaborators;
        this.isDownloaded = isDownloaded;
        this.trip_cover_picture = trip_cover_picture;
    }
}
