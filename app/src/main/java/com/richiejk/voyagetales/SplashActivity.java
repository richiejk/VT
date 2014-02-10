package com.richiejk.voyagetales;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.richiejk.voyagetales.common.CommonUtils;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.data.DBHandler;
import com.richiejk.voyagetales.models.BlockModel;

import java.util.logging.Handler;

public class SplashActivity extends VoyageTalesActivity {
    VoyageTalesApplication application;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        application=(VoyageTalesApplication)getApplication();
        dbHandler=new DBHandler(this);
        if(CommonUtils.checkIfLoginIsSaved(this)== Finals.SHARED_PREFS_IS_LOGGED_IN_TRUE){

            if(CommonUtils.checkIfCurrentlyOnTrip(this)==Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE){
                application.setCurrentTrip(dbHandler.getTrip(CommonUtils.getCurrentTripId(this)));
                if(CommonUtils.getCurrentBlockId(this)!=0){
                    application.setTripKey(CommonUtils.getCurrentTripKey(this));
                    BlockModel block=dbHandler.getBlock(CommonUtils.getCurrentBlockId(this));
                    application.setCurrentBlock(block);
                    application.TRIP_CURRENT_TYPE=block.getBlockType();
                }

            }
        }
        android.os.Handler handler=new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,LandingActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        },2000);

    }

}
