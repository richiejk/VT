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
        editor.commit();
    }

    public static int checkIfCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,0);
    }

    public static void setCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE);
        editor.commit();
    }

    public static void removeCurrentlyOnTrip(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_CHECK,Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_FALSE);
        editor.commit();
    }

    public static int getCurrentUserId(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENT_USER_ID,0);
    }

    public static void setCurrentUserId(Context context,int id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENT_USER_ID,id);
        editor.commit();
    }

    public static int getCurrentTripId(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENT_TRIP_ID,0);
    }

    public static void setCurrentTripId(Context context,int id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENT_TRIP_ID,id);
        editor.commit();
    }

    public static int getCurrentBlockId(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Finals.SHARED_PREFS_CURRENT_BLOCK_ID,0);
    }

    public static void setCurrentBlockId(Context context,int id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("USER_DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(Finals.SHARED_PREFS_CURRENT_BLOCK_ID,id);
        editor.commit();
    }

}
