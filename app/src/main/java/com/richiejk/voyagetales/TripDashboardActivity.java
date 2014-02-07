package com.richiejk.voyagetales;

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

import com.richiejk.voyagetales.common.Finals;

import org.w3c.dom.Text;

public class TripDashboardActivity extends VoyageTalesActivity {


    class UISet{
        EditText location_name,location_desc,travel_from,travel_to,travel_location_name;
        TextView location_name_final,location_desc_final,travel_from_final,travel_to_final,travel_location_name_final;
        ImageView cam,note,audio,coll,check_in,stop_trip,switch_type;
        LinearLayout ll_location_init,ll_location_final,ll_travel_init,ll_travel_final;
        Button save_location,save_travel;
    }
    UISet ui=new UISet();
    VoyageTalesApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_dashboard);
        application=(VoyageTalesApplication)getApplication();
        initUI();
        setListeners();
    }

    void initUI(){
        ui.ll_location_init=(LinearLayout)findViewById(R.id.ll_dashboard_location_et);
        ui.ll_location_final=(LinearLayout)findViewById(R.id.ll_dashboard_location_txt);
        ui.location_name=(EditText)findViewById(R.id.editText_location_dashboard_location_name);
        ui.location_desc=(EditText)findViewById(R.id.editText_location_dashboard_location_desc);
        ui.location_name_final=(TextView)findViewById(R.id.txt_location_dashboard_location_name);
        ui.location_desc_final=(TextView)findViewById(R.id.txt_location_dashboard_location_desc);

        ui.ll_location_init.setVisibility(View.VISIBLE);
        ui.ll_location_final.setVisibility(View.GONE);


        application.TRIP_CURRENT_TYPE= Finals.TRIP_TYPE_LOCATION;
        ui.save_location=(Button)findViewById(R.id.btn_dashboard_location_save);


    }

    void setListeners(){
        ui.save_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.setLocation_name(ui.location_name.getText().toString());
                application.setLocation_desc(ui.location_desc.getText().toString());
                ui.location_name_final.setText(application.getLocation_name());
                ui.location_desc_final.setText(application.getLocation_desc());
                ui.ll_location_init.setVisibility(View.GONE);
                ui.ll_location_final.setVisibility(View.VISIBLE);

            }
        });
    }



}
