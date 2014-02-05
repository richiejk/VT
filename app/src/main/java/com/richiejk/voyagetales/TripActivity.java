package com.richiejk.voyagetales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TripActivity extends VoyageTalesActivity {
    class UISet{
        TextView name;
        ImageView settings,logout;
        ListView tripsList;
    }
    UISet ui=new UISet();
    VoyageTalesApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        application=(VoyageTalesApplication)getApplication();
        init();
    }

    void init(){
        ui.tripsList=(ListView)findViewById(R.id.listView_trips);
        ui.name=(TextView)findViewById(R.id.txt_name);

        ui.name.setText("("+application.getCurrent_user().getUser_name()+")");
        ui.settings=(ImageView)findViewById(R.id.img_settings);
        ui.logout=(ImageView)findViewById(R.id.img_logout);
    }

}
