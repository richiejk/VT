package com.richiejk.voyagetales.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by richie on 1/31/14.
 */
public class CommonUtils {

    public static int checkIfLoginIsSaved(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_IS_LOGGED_IN_CHECK,0);
    }

    public static void changeLoginSavedStatus(Context context,int value){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_IS_LOGGED_IN_CHECK,value);
    }

    public static int checkIfCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,0);
    }

    public static void setCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE);
    }

    public static void removeCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_FALSE);
    }

    public static int getCurrentUserId(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENT_USER_ID,0);
    }

    public static void setCurrentUserId(Context context,int id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENT_USER_ID,id);
    }


}
