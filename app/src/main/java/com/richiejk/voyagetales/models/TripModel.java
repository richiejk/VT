package com.richiejk.voyagetales.models;

/**
 * Created by Richie on 11/3/14.
 */
public class TripModel {
    int tripId;
    int userId;
    String tripName;
    String createdOn;
    String startDate;
    String description;
    double rating;
    int votes;
    LocationModel startLocation;
    LocationModel endLocation;
    String endDate;
    int status;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public LocationModel getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationModel startLocation) {
        this.startLocation = startLocation;
    }

    public LocationModel getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationModel endLocation) {
        this.endLocation = endLocation;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TripModel(int tripId, int userId, String tripName, String createdOn, String startDate, String description, double rating, int votes, LocationModel startLocation, LocationModel endLocation, String endDate, int status) {
        this.tripId = tripId;
        this.userId = userId;
        this.tripName = tripName;
        this.createdOn = createdOn;
        this.startDate = startDate;
        this.description = description;
        this.rating = rating;
        this.votes = votes;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.endDate = endDate;
        this.status = status;
    }
}
