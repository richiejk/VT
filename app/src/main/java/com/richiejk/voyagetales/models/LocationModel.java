package com.richiejk.voyagetales.models;

/**
 * Created by Richie on 11/3/14.
 */
public class LocationModel {

    String locationName;
    String latitude;
    String longitude;

    public LocationModel(String locationName, String latitude, String longitude) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
