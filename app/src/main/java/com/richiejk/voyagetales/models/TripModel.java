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
    int collaborators_count;
    int rating;
    ArrayList<FriendModel> collaborators;
    String collaborators_ids;
    boolean isDownloaded;
    String trip_cover_picture;
    boolean isPublished;

    String trip_key;
    String trip_starting_from;
    String trip_ending_at;
    int sync_status;

    public String getCollaborators_ids() {
        return collaborators_ids;
    }

    public void setCollaborators_ids(String collaborators_ids) {
        this.collaborators_ids = collaborators_ids;
    }

    public String getTrip_ending_at() {
        return trip_ending_at;
    }

    public void setTrip_ending_at(String trip_ending_at) {
        this.trip_ending_at = trip_ending_at;
    }

    public String getTrip_key() {
        return trip_key;
    }

    public void setTrip_key(String trip_key) {
        this.trip_key = trip_key;
    }

    public String getTrip_starting_from() {
        return trip_starting_from;
    }

    public void setTrip_starting_from(String trip_starting_from) {
        this.trip_starting_from = trip_starting_from;
    }

    public int getSync_status() {
        return sync_status;
    }

    public void setSync_status(int sync_status) {
        this.sync_status = sync_status;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public int getCollaborators_count() {
        return collaborators_count;
    }

    public void setCollaborators_count(int collaborators_count) {
        this.collaborators_count = collaborators_count;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

    public TripModel(String trip_name, int trip_id, String trip_description, int trip_status, String trip_start_date, String trip_end_date, int fans_count, int rating, ArrayList<FriendModel> collaborators, boolean isDownloaded, String trip_cover_picture,int collaborators_count,boolean isPublished) {
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
        this.collaborators_count=collaborators_count;
        this.isPublished=isPublished;
    }

    public TripModel(String trip_name, int trip_id, String trip_description, int trip_status, String trip_start_date, String trip_end_date, int fans_count, int collaborators_count, int rating, ArrayList<FriendModel> collaborators, boolean isDownloaded, String trip_cover_picture, boolean isPublished, String trip_key, String trip_starting_from, int sync_status,String trip_ending_at) {
        this.trip_name = trip_name;
        this.trip_id = trip_id;
        this.trip_description = trip_description;
        this.trip_status = trip_status;
        this.trip_start_date = trip_start_date;
        this.trip_end_date = trip_end_date;
        this.fans_count = fans_count;
        this.collaborators_count = collaborators_count;
        this.rating = rating;
        this.collaborators = collaborators;
        this.isDownloaded = isDownloaded;
        this.trip_cover_picture = trip_cover_picture;
        this.isPublished = isPublished;
        this.trip_key = trip_key;
        this.trip_starting_from = trip_starting_from;
        this.sync_status = sync_status;
        this.trip_ending_at=trip_ending_at;
    }

    public TripModel(String trip_name, int trip_id, String trip_description, int trip_status, String trip_start_date, String trip_end_date, int fans_count, int collaborators_count, int rating, ArrayList<FriendModel> collaborators, String collaborators_ids, boolean isDownloaded, String trip_cover_picture, boolean isPublished, String trip_key, String trip_starting_from, String trip_ending_at, int sync_status) {
        this.trip_name = trip_name;
        this.trip_id = trip_id;
        this.trip_description = trip_description;
        this.trip_status = trip_status;
        this.trip_start_date = trip_start_date;
        this.trip_end_date = trip_end_date;
        this.fans_count = fans_count;
        this.collaborators_count = collaborators_count;
        this.rating = rating;
        this.collaborators = collaborators;
        this.collaborators_ids = collaborators_ids;
        this.isDownloaded = isDownloaded;
        this.trip_cover_picture = trip_cover_picture;
        this.isPublished = isPublished;
        this.trip_key = trip_key;
        this.trip_starting_from = trip_starting_from;
        this.trip_ending_at = trip_ending_at;
        this.sync_status = sync_status;
    }


    public TripModel(String trip_name, int trip_id, String trip_description, int trip_status, String trip_start_date, String trip_end_date, int collaborators_count, String collaborators_ids, String trip_cover_picture, String trip_key, String trip_starting_from, String trip_ending_at, int sync_status) {
        this.trip_name = trip_name;
        this.trip_id = trip_id;
        this.trip_description = trip_description;
        this.trip_status = trip_status;
        this.trip_start_date = trip_start_date;
        this.trip_end_date = trip_end_date;
        this.collaborators_count = collaborators_count;
        this.collaborators_ids = collaborators_ids;
        this.trip_cover_picture = trip_cover_picture;
        this.trip_key = trip_key;
        this.trip_starting_from = trip_starting_from;
        this.trip_ending_at = trip_ending_at;
        this.sync_status = sync_status;
    }
}
