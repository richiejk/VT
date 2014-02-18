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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.richiejk.voyagetales.adapters.TimelineAdapter;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.BlockModel;

import java.util.ArrayList;
import java.util.List;

public class TestTripDashboard extends VoyageTalesActivity {


    ListView listView;
    ArrayList<BlockModel> blocks;
    int selectedItem=-1;
    VoyageTalesApplication application;
    class UISet{
        LinearLayout ll_bottom_add_layout,ll_bottom_add_layout_inner;
        TextView name_text_header,trip_name,trip_desc,trip_time;
        ImageView settings_header,logout_header,cam,check_in,add_friend,note,audio,stop_trip,add_before,add_after;
    }
    UISet ui=new UISet();
    TimelineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_trip_dashboard);
        application=(VoyageTalesApplication)getApplication();
        initUI();
        setListeners();

    }

    void initUI(){
        addDummyData();
        listView=(ListView)findViewById(R.id.list_test_timeline);
        adapter=new TimelineAdapter(this,R.id.txt_location_name_test_timeline,blocks);
        listView.setAdapter(adapter);

        ui.ll_bottom_add_layout=(LinearLayout)findViewById(R.id.ll_test_trip_dashboard_bottom_add);
        ui.ll_bottom_add_layout_inner=(LinearLayout)findViewById(R.id.ll_test_trip_dashboard_bottom_add_inner);
        ui.name_text_header=(TextView)findViewById(R.id.txt_name);
        ui.cam=(ImageView)findViewById(R.id.img_test_travel_dashboard_cam);
        ui.note=(ImageView)findViewById(R.id.img_test_travel_dashboard_note);
        ui.audio=(ImageView)findViewById(R.id.img_test_travel_dashboard_audio);
        ui.stop_trip=(ImageView)findViewById(R.id.img_test_travel_dashboard_stop_trip);
        ui.check_in=(ImageView)findViewById(R.id.img_test_travel_dashboard_check_in);
        ui.add_friend=(ImageView)findViewById(R.id.img_test_travel_dashboard_add_coll);
        ui.settings_header=(ImageView)findViewById(R.id.img_settings);
        ui.logout_header=(ImageView)findViewById(R.id.img_logout);
        ui.add_before=(ImageView)findViewById(R.id.img_test_travel_dashboard_add_before);
        ui.add_after=(ImageView)findViewById(R.id.img_test_travel_dashboard_add_after);
        ui.trip_name=(TextView)findViewById(R.id.txt_test_travel_dashboard_trip_name);
        ui.trip_desc=(TextView)findViewById(R.id.txt_test_travel_dashboard_trip_desc);
        ui.trip_time=(TextView)findViewById(R.id.txt_test_travel_dashboard_trip_time);

        ui.ll_bottom_add_layout_inner.setVisibility(View.INVISIBLE);
        listView.setSelection(0);

        ui.trip_name.setText(application.getCurrentTrip().getTrip_name());
        ui.trip_desc.setText(application.getCurrentTrip().getTrip_description());
        ui.trip_time.setText("Trip Started On: " + application.getCurrentTrip().getTrip_start_date());

        ui.name_text_header.setText("(richie)");
//        ui.trip_name.setText("Test Static Trip");
//        ui.trip_desc.setText("This is a static trip used only to test blah blah blah blah");
//        ui.trip_time.setText("Trip Started On: 13/02/2014 12:37");


    }

    void setListeners(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ui.ll_bottom_add_layout_inner.setVisibility(View.VISIBLE);
                view.setSelected(true);
                view.setEnabled(true);

                view.setSelected(true);
                view.setEnabled(true);

                selectedItem=i;

           //    Toast.makeText(TestTripDashboard.this,i+"",Toast.LENGTH_LONG).show()  ;
            }
        });
    }


    void addDummyData(){
        blocks=new ArrayList<BlockModel>();
        blocks.add(new BlockModel("Trivandrum","123.123","123.45","TVM","Gonna leave from tvm today","01/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Chennai","123.123","123.45","MAA","Gonna reach Blore after this","03/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Bangalore","123.123","123.45","BLR","Fun at wonderla","06/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Hyderabad","123.123","123.45","HYD","At Ramoji Film City","08/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
    }

}
