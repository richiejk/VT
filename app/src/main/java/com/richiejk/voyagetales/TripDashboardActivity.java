package com.richiejk.voyagetales;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.richiejk.voyagetales.common.CommonUtils;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.gps.GPSTracker;
import com.richiejk.voyagetales.models.BlockModel;

import org.w3c.dom.Text;

public class TripDashboardActivity extends VoyageTalesActivity {


    class UISet{
        EditText location_name,location_desc,travel_from,travel_to,travel_location_name;
        TextView location_name_final,location_desc_final,travel_from_final,travel_to_final,travel_location_name_final;
        ImageView cam,note,audio,coll,check_in,stop_trip,switch_type_from_location,switch_type_from_travel;
        LinearLayout ll_location_init,ll_location_final,ll_travel_init,ll_travel_final;
        Button save_location,save_travel;
    }
    UISet ui=new UISet();
    VoyageTalesApplication application;
    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_dashboard);
        application=(VoyageTalesApplication)getApplication();
        initUI();
        setListeners();
        gpsTracker=new GPSTracker(this);
        if(!gpsTracker.canGetLocation()){
            gpsTracker.showSettingsAlert();
        }
    }

    void initUI(){
        ui.ll_location_init=(LinearLayout)findViewById(R.id.ll_dashboard_location_et);
        ui.ll_location_final=(LinearLayout)findViewById(R.id.ll_dashboard_location_txt);
        ui.location_name=(EditText)findViewById(R.id.editText_location_dashboard_location_name);
        ui.location_desc=(EditText)findViewById(R.id.editText_location_dashboard_location_desc);
        ui.location_name_final=(TextView)findViewById(R.id.txt_location_dashboard_location_name);
        ui.location_desc_final=(TextView)findViewById(R.id.txt_location_dashboard_location_desc);

        ui.travel_from=(EditText)findViewById(R.id.editText_travel_dashboard_from);
        ui.travel_to=(EditText)findViewById(R.id.editText_travel_dashboard_to);
        ui.travel_location_name=(EditText)findViewById(R.id.editText_travel_dashboard_desc);

        ui.travel_from_final=(TextView)findViewById(R.id.txt_travel_dashboard_from);
        ui.travel_to_final=(TextView)findViewById(R.id.txt_travel_dashboard_to);
        ui.travel_location_name_final=(TextView)findViewById(R.id.txt_travel_dashboard_desc);

        ui.ll_travel_init=(LinearLayout)findViewById(R.id.ll_dashboard_travel_et);
        ui.ll_travel_final=(LinearLayout)findViewById(R.id.ll_dashboard_travel_txt);

        ui.save_travel=(Button)findViewById(R.id.save_travel);

        ui.cam=(ImageView)findViewById(R.id.img_travel_dashboard_cam);
        ui.note=(ImageView)findViewById(R.id.img_travel_dashboard_note);
        ui.audio=(ImageView)findViewById(R.id.img_travel_dashboard_audio);
        ui.coll=(ImageView)findViewById(R.id.img_travel_dashboard_add_coll);
        ui.check_in=(ImageView)findViewById(R.id.img_travel_dashboard_check_in);
        ui.stop_trip=(ImageView)findViewById(R.id.img_travel_dashboard_stop_trip);
        ui.switch_type_from_location=(ImageView)findViewById(R.id.switch_type_from_location);
        ui.switch_type_from_travel=(ImageView)findViewById(R.id.switch_type_from_travel);

        if(application.getCurrentBlock()!=null){
            if(application.TRIP_CURRENT_TYPE==Finals.TRIP_TYPE_LOCATION){
                ui.ll_location_init.setVisibility(View.GONE);
                ui.ll_travel_init.setVisibility(View.GONE);
                ui.ll_travel_final.setVisibility(View.GONE);
                ui.location_name_final.setText(application.getCurrentBlock().getBlockLocation());
                ui.location_desc_final.setText(application.getCurrentBlock().getBlockDescription());
                ui.ll_location_final.setVisibility(View.VISIBLE);
            }else{
                ui.ll_location_init.setVisibility(View.GONE);
                ui.ll_travel_init.setVisibility(View.GONE);
                ui.ll_travel_final.setVisibility(View.VISIBLE);
                ui.travel_from_final.setText(application.getCurrentBlock().getTravelFrom());
                ui.travel_to_final.setText(application.getCurrentBlock().getTravelTo());
                ui.ll_location_final.setVisibility(View.GONE);
            }
        }else{
            ui.ll_location_init.setVisibility(View.VISIBLE);
            ui.ll_location_final.setVisibility(View.GONE);
            ui.ll_travel_init.setVisibility(View.GONE);
            ui.ll_travel_final.setVisibility(View.GONE);
            application.TRIP_CURRENT_TYPE= Finals.TRIP_TYPE_LOCATION;
        }




        ui.save_location=(Button)findViewById(R.id.btn_dashboard_location_save);


    }

    void setListeners(){

        ui.save_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!gpsTracker.canGetLocation()){
                    showMapSelecterAlert();
                }else{
                    gpsTracker.getLocation();
                }
                //   application.setCurrentBlock(new BlockModel(ui.location_name.getText().toString(),  gpsTracker.getLatitude()+"", gpsTracker.getLongitude()+"", ui.location_name.getText().toString(),ui.location_desc.getText().toString(), CommonUtils.getCurrentDateTime(), Finals.TRIP_TYPE_LOCATION, application.getTripKey(), 0 ,application.getCurrentTrip().getTrip_id()));


                application.setCurrentBlock(new BlockModel(ui.travel_from.getText().toString(),  gpsTracker.getLatitude()+"", gpsTracker.getLongitude()+"", ui.location_desc.getText().toString(), CommonUtils.getCurrentDateTime(), Finals.TRIP_TYPE_TRAVEL,"asdasd", 0,ui.travel_to.getText().toString() ,1));
                ui.travel_from_final.setText(application.getCurrentBlock().getTravelFrom());
                ui.travel_to_final.setText(application.getCurrentBlock().getTravelTo());
                //CommonUtils.setCurrentBlockId(TripDashboardActivity.this,application.getCurrentBlock().getBlockId());
                //todo add to db

            }
        });

        ui.switch_type_from_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(TripDashboardActivity.this).create();
                dialog.setMessage("Are you sure you're leaving this location?");
                dialog.setTitle("Check out?");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ui.ll_location_init.setVisibility(View.GONE);
                        ui.ll_location_final.setVisibility(View.GONE);
                        ui.ll_travel_final.setVisibility(View.GONE);
                        ui.ll_travel_init.setVisibility(View.VISIBLE);
                    }
                });

                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });

        ui.switch_type_from_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(TripDashboardActivity.this).create();
                dialog.setMessage("Are you sure you're ready to check in at a location?");
                dialog.setTitle("Check in?");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ui.ll_location_init.setVisibility(View.VISIBLE);
                        ui.ll_location_final.setVisibility(View.GONE);
                        ui.ll_travel_final.setVisibility(View.GONE);
                        ui.ll_travel_init.setVisibility(View.GONE);
                    }
                });

                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });

        ui.save_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!gpsTracker.canGetLocation()){
                    showMapSelecterAlert();
                }else{
                    gpsTracker.getLocation();
                }
                 //   application.setCurrentBlock(new BlockModel(ui.location_name.getText().toString(),  gpsTracker.getLatitude()+"", gpsTracker.getLongitude()+"", ui.location_name.getText().toString(),ui.location_desc.getText().toString(), CommonUtils.getCurrentDateTime(), Finals.TRIP_TYPE_LOCATION, application.getTripKey(), 0 ,application.getCurrentTrip().getTrip_id()));
                application.setCurrentBlock(new BlockModel(ui.location_name.getText().toString(),  gpsTracker.getLatitude()+"", gpsTracker.getLongitude()+"", ui.location_name.getText().toString(),ui.location_desc.getText().toString(), CommonUtils.getCurrentDateTime(), Finals.TRIP_TYPE_LOCATION,"asdasd", 0 ,1));
                ui.location_name_final.setText(application.getCurrentBlock().getBlockLocation());
                ui.location_desc_final.setText(application.getCurrentBlock().getBlockDescription());
                //CommonUtils.setCurrentBlockId(TripDashboardActivity.this,application.getCurrentBlock().getBlockId());
                //todo add to db

                ui.ll_location_init.setVisibility(View.GONE);
                ui.ll_location_final.setVisibility(View.VISIBLE);

            }
        });
    }

    public void showMapSelecterAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        // Setting Dialog Title
        alertDialog.setTitle("GPS is disabled");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. The full functionality of this app cannot be enjoyed without location capabilities");

        // On pressing Settings button
        alertDialog.setPositiveButton("Go to settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Select on Map", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }



}
