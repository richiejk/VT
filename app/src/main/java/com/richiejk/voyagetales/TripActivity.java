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

import com.richiejk.voyagetales.adapters.FriendAdapter;
import com.richiejk.voyagetales.adapters.TripAdapter;
import com.richiejk.voyagetales.models.FriendModel;
import com.richiejk.voyagetales.models.TripModel;

import java.util.ArrayList;

public class TripActivity extends VoyageTalesActivity {
    class UISet{
        TextView name;
        ImageView settings,logout;
        ListView tripsList;
    }
    UISet ui=new UISet();
    VoyageTalesApplication application;
    ArrayList<TripModel> trips;
    TripAdapter tripAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        application=(VoyageTalesApplication)getApplication();
        init();
        addDummyData();
        tripAdapter=new TripAdapter(this,R.id.txt_item_trips_list_name,trips);
        ui.tripsList.setAdapter(tripAdapter);
    }

    void init(){
        ui.tripsList=(ListView)findViewById(R.id.listView_trips);
        ui.name=(TextView)findViewById(R.id.txt_name);

        ui.name.setText("("+application.getCurrent_user().getUser_name()+")");
        ui.settings=(ImageView)findViewById(R.id.img_settings);
        ui.logout=(ImageView)findViewById(R.id.img_logout);
    }

    void addDummyData(){
        trips=new ArrayList<TripModel>();
        trips.add(new TripModel("Trip-1",1,"first test trip to blah blah blah blah",1,"27-01-2014","02-02-2014",10,1,new ArrayList<FriendModel>(),false,"http://3.bp.blogspot.com/-VJ6BKFj7k4U/UETJEFBDPrI/AAAAAAAACIc/BUSk_ozZEJk/s1600/City+Wallpapers+3.jpg",0,true));
        trips.add(new TripModel("My special Trip",2,"special trup test trip to blah blah blah blah",1,"17-01-2014","03-02-2014",1,2,new ArrayList<FriendModel>(),false,"http://4.bp.blogspot.com/-c8Tnsoq1IjE/UDsk0cpg2GI/AAAAAAAAISA/r36wSAKwexU/s1600/Night+City+Glow+Wallpapers+1.jpg",0,true));
        trips.add(new TripModel("Another trip",3,"first test trip to blah blah blah blah",1,"07-01-2014","07-02-2014",16,5,new ArrayList<FriendModel>(),false,"http://backgroundhdwallpaper.com/wp-content/uploads/2013/03/Awesome-City-Pictures-Background-HD-Wallpaper.jpg",0,true));
        trips.add(new TripModel("Test Trip",4,"first to be tested is this test trip to blah blah blah blah",1,"02-01-2013","02-02-2013",23,4,new ArrayList<FriendModel>(),false,"http://2.bp.blogspot.com/-2bMkf-N6c9g/UETJHNQ2_2I/AAAAAAAACIk/3fETGAt2MCY/s1600/City+Wallpapers+4.jpg",0,true));
        trips.add(new TripModel("New Test Trip",5,"this is another test trip to blah blah blah blah",1,"27-12-2012","01-01-2012",2,3,new ArrayList<FriendModel>(),false,"http://www.hdwallpapers3d.com/wp-content/uploads/2013/05/brisbane-city-hd-wallpaper-cityscapes-night.jpg",0,true));
    }

}
