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
import android.widget.ListView;

import com.richiejk.voyagetales.adapters.TimelineAdapter;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.models.BlockModel;

import java.util.ArrayList;
import java.util.List;

public class TestTripDashboard extends VoyageTalesActivity {


    ListView listView;
    ArrayList<BlockModel> blocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_trip_dashboard);
        initUI();
    }

    void initUI(){
        addDummyData();
        listView=(ListView)findViewById(R.id.list_test_timeline);
        TimelineAdapter adapter=new TimelineAdapter(this,R.id.txt_location_name_test_timeline,blocks);
        listView.setAdapter(adapter);
    }

    void addDummyData(){
        blocks=new ArrayList<BlockModel>();
        blocks.add(new BlockModel("Trivandrum","123.123","123.45","TVM","Gonna leave from tvm today","01/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Chennai","123.123","123.45","MAA","Gonna reach Blore after this","03/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Bangalore","123.123","123.45","BLR","Fun at wonderla","06/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
        blocks.add(new BlockModel("Hyderabad","123.123","123.45","HYD","At Ramoji Film City","08/01/2014 09:00", Finals.TRIP_TYPE_LOCATION,"123",0,1));
    }

}
