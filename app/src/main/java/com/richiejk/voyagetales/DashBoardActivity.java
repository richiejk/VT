package com.richiejk.voyagetales;

import android.content.Intent;
import android.opengl.Visibility;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.richiejk.voyagetales.common.CommonUtils;
import com.richiejk.voyagetales.common.Finals;

import org.w3c.dom.Text;

public class DashBoardActivity extends VoyageTalesActivity {

    boolean isOnTrip;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    class UISet{
        LinearLayout me,friends,trips,messages,startTrip,home,upper_menu,lower_menu;
        ImageView logout,settings;
        TextView name;
    }

    VoyageTalesApplication application;

    UISet ui=new UISet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        application=(VoyageTalesApplication)getApplication();
        initUI();
        setListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        isOnTrip= CommonUtils.checkIfCurrentlyOnTrip(this)== Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE;
        if(isOnTrip){
            application.IS_ON_TRIP=Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE;
            ui.startTrip.setVisibility(View.GONE);
        }
        ui.name.setText("("+application.getCurrent_user().getUser_name()+")");
    }

    void initUI(){
        ui.me=(LinearLayout)findViewById(R.id.ll_dashboard_me);
        ui.friends=(LinearLayout)findViewById(R.id.ll_dashboard_friends);
        ui.trips=(LinearLayout)findViewById(R.id.ll_dashboard_trips);
        ui.messages=(LinearLayout)findViewById(R.id.ll_dashboard_messages);
        ui.startTrip=(LinearLayout)findViewById(R.id.ll_dashboard_start_trip);
        ui.home=(LinearLayout)findViewById(R.id.ll_dashboard_home);
        ui.name=(TextView)findViewById(R.id.txt_dashboard_name);

        ui.logout=(ImageView)findViewById(R.id.img_dashboard_logout);
        ui.settings=(ImageView)findViewById(R.id.img_dashboard_settings);

        ui.upper_menu=(LinearLayout)findViewById(R.id.ll_dashboard_upper_menu);
        ui.lower_menu=(LinearLayout)findViewById(R.id.ll_dashboard_lower_menu);
    }

    void setListeners(){
        ui.me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashBoardActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        ui.friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashBoardActivity.this,FriendsActivity.class);
                startActivity(intent);
            }
        });

        ui.trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashBoardActivity.this,TripActivity.class);
                startActivity(intent);
            }
        });

        ui.messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ui.startTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DashBoardActivity.this,TestTripDashboard.class);
                startActivity(intent);
            }
        });

        ui.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ui.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processLogout();
                CommonUtils.changeLoginSavedStatus(DashBoardActivity.this,Finals.SHARED_PREFS_IS_LOGGED_IN_FALSE);
                Intent intent=new Intent(DashBoardActivity.this,LandingActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ui.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
