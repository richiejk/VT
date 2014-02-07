package com.richiejk.voyagetales;

import android.app.Application;
import android.graphics.Typeface;

import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.UserModel;

/**
 * Created by richie on 1/16/14.
 */
public class VoyageTalesApplication extends Application {
    UserModel current_user;
    public int IS_ON_TRIP= Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_FALSE;
    public int TRIP_CURRENT_TYPE;
    int travel_type_id;

    String location_name;
    String location_desc;
    String travel_from;
    String travel_to;

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_desc() {
        return location_desc;
    }

    public void setLocation_desc(String location_desc) {
        this.location_desc = location_desc;
    }

    public String getTravel_from() {
        return travel_from;
    }

    public void setTravel_from(String travel_from) {
        this.travel_from = travel_from;
    }

    public String getTravel_to() {
        return travel_to;
    }

    public void setTravel_to(String travel_to) {
        this.travel_to = travel_to;
    }

    public int getTravel_type_id() {
        return travel_type_id;
    }

    public void setTravel_type_id(int travel_type_id) {
        this.travel_type_id = travel_type_id;
    }

    public UserModel getCurrent_user() {
        if(current_user!=null){
            return current_user;
        }else{
            return new UserModel();
        }
    }

    public void setCurrent_user(UserModel current_user) {
        this.current_user = current_user;
    }

    public int getIS_ON_TRIP() {
        return IS_ON_TRIP;
    }

    public void setIS_ON_TRIP(int IS_ON_TRIP) {
        this.IS_ON_TRIP = IS_ON_TRIP;
    }

    Typeface typeface;

    public Typeface getTypeface() {
        if(typeface==null){
            typeface= Typeface.createFromAsset(getAssets(), "fonts/VarelaRound.otf");
            return typeface;
        }else{
            return typeface;
        }

    }
}
