package com.richiejk.voyagetales;

import android.app.Application;

import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.UserModel;

/**
 * Created by richie on 1/16/14.
 */
public class VoyageTalesApplication extends Application {
    UserModel current_user;
    public int IS_ON_TRIP= Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_FALSE;

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
}
