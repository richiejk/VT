package com.richiejk.voyagetales;

import android.app.Application;
import android.graphics.Typeface;

import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.BlockModel;
import com.richiejk.voyagetales.models.TripModel;
import com.richiejk.voyagetales.models.UserModel;

/**
 * Created by richie on 1/16/14.
 */
public class VoyageTalesApplication extends Application {
    UserModel current_user;
    public int IS_ON_TRIP= Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_FALSE;
    public int TRIP_CURRENT_TYPE;
    int travel_type_id;
    int trip_id;
    String tripKey;
    BlockModel currentBlock;
    TripModel currentTrip;

    public String getTripKey() {
        return tripKey;
    }

    public void setTripKey(String tripKey) {
        this.tripKey = tripKey;
    }

    public TripModel getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(TripModel currentTrip) {
        this.currentTrip = currentTrip;
    }

    public BlockModel getCurrentBlock() {


        return currentBlock;
    }

    public void setCurrentBlock(BlockModel currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
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
