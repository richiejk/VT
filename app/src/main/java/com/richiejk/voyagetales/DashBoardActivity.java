package com.richiejk.voyagetales;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.richiejk.voyagetales.common.CommonUtils;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.data.DBHandler;
import com.richiejk.voyagetales.models.TripModel;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

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
                final Dialog dialog = new Dialog(DashBoardActivity.this,android.R.style.Theme_Translucent);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.item_dialog_add_new_trip);


                Button start=(Button)dialog.findViewById(R.id.btn_dialog_start_trip_start);
                TextView title=(TextView)dialog.findViewById(R.id.txt_title);
                TextView select_pic=(TextView)dialog.findViewById(R.id.txt_dialog_start_trip_select_trip_pic_title);
                final TextView trip_name=(TextView)dialog.findViewById(R.id.editText_dialog_start_trip_tripname);
                final TextView trip_desc=(TextView)dialog.findViewById(R.id.editText_dialog_start_trip_tripdesc);
                ImageView cam_img=(ImageView)dialog.findViewById(R.id.img_dialog_start_trip_cam);
                TextView img_name=(TextView)dialog.findViewById(R.id.txt_dialog_start_trip_trip_img_name);
                img_name.setText("");

                title.setTypeface(typeface);
                start.setTypeface(typeface);
                select_pic.setTypeface(typeface);
                trip_name.setTypeface(typeface);
                trip_desc.setTypeface(typeface);
                img_name.setTypeface(typeface);

                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(trip_name.getText().length()==0){
                            trip_name.setError("Please enter a name for the trip");
                        }else{
                            application.setTripKey("asd");
                            application.IS_ON_TRIP=Finals.SHARED_PREFS_CURRENTLY_ON_TRIP_TRUE;

                            long tKey=CommonUtils.getCurrentDateTimeInMillis();
                            TripModel currentTrip=new TripModel(trip_name.getText().toString(),0, trip_desc.getText().toString(),0, CommonUtils.getCurrentDateTime(), false, "", false, tKey+"", Finals.SYNC_STATUS_FALSE);
                            DBHandler handler=new DBHandler(DashBoardActivity.this);
                            handler.insertTrip(currentTrip);
                            currentTrip=handler.getTrip(tKey);
                            Toast.makeText(DashBoardActivity.this,currentTrip.getTrip_id()+"",Toast.LENGTH_LONG).show();
                            application.currentTrip=currentTrip;
                            CommonUtils.setCurrentTripId(DashBoardActivity.this,application.getCurrentTrip().getTrip_id());
                            CommonUtils.setCurrentTripKey(DashBoardActivity.this, application.getCurrentTrip().getTrip_key());
                            Intent intent=new Intent(DashBoardActivity.this,TestTripDashboard.class);
                            dialog.dismiss();
                            CommonUtils.setCurrentlyOnTrip(DashBoardActivity.this);
                            startActivity(intent);
                        }
                    }
                });
                dialog.show();



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
