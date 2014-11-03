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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.richiejk.voyagetales.adapters.FriendAdapter;
import com.richiejk.voyagetales.models.FriendModel;

import java.util.ArrayList;

public class FriendsActivity extends VoyageTalesActivity {

    class UISet{
        TextView name;
        ImageView settings,logout;
        ListView friendsList;
        Button tab_friends,tab_fans;
    }
    UISet ui=new UISet();
    ArrayList<FriendModel> friends;
    ArrayList<FriendModel> fans;
    ArrayList<FriendModel> listDataToDisplay;
    VoyageTalesApplication application;
    final int FRIENDS_TAB=0;
    final int FANS_TAB=1;
    int selected_tab=0;
    FriendAdapter friendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        application=(VoyageTalesApplication)getApplication();
        initUI();
        addDummyData();
        listDataToDisplay=(ArrayList<FriendModel>)friends.clone();
        friendAdapter= new FriendAdapter(this,R.id.txt_item_friends_list_name,listDataToDisplay);
        ui.friendsList.setAdapter(friendAdapter);
        setListeners();
        selected_tab=0;
        select_tab(FRIENDS_TAB);
    }

    void addDummyData(){
        friends=new ArrayList<FriendModel>();
        friends.add(new FriendModel(1,"richie 1","richie@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        friends.add(new FriendModel(2,"richie 2","richie2@gmail.com","https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-ash3/t1/q71/s720x720/1794559_665756510141313_1026294576_n.jpg",0,0,0));
        friends.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        friends.add(new FriendModel(4,"richie 4","richie4@gmail.com","https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-ash3/t1/q71/s720x720/1794559_665756510141313_1026294576_n.jpg",0,0,0));
        friends.add(new FriendModel(5,"richie 5","richie5@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        friends.add(new FriendModel(6,"richie 6","richie6@gmail.com","https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-ash3/t1/q71/s720x720/1794559_665756510141313_1026294576_n.jpg",0,0,0));

        fans=new ArrayList<FriendModel>();
        fans.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        fans.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        fans.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        fans.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
        fans.add(new FriendModel(3,"richie 3","richie3@gmail.com","http://static.tumblr.com/vowtf1z/M3Kmwaquu/flip.jpg",0,0,0));
    }

    void initUI(){
        ui.friendsList=(ListView)findViewById(R.id.listView_friends);
        ui.name=(TextView)findViewById(R.id.txt_name);

        ui.name.setText("("+application.getCurrent_user().getUser_name()+")");
        ui.settings=(ImageView)findViewById(R.id.img_settings);
        ui.logout=(ImageView)findViewById(R.id.img_logout);

        ui.tab_friends=(Button)findViewById(R.id.btn_friends_tabs_friends);
        ui.tab_fans=(Button)findViewById(R.id.btn_friends_tabs_fans);
    }

    void setListeners(){


        ui.tab_fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select_tab(FANS_TAB);
            }
        });

        ui.tab_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select_tab(FRIENDS_TAB);
            }
        });
    }

    void deselectAll(){
        ui.tab_friends.setBackgroundColor(getResources().getColor(R.color.darker_transparent_black_button_bg));
        ui.tab_fans.setBackgroundColor(getResources().getColor(R.color.darker_transparent_black_button_bg));
    }

    void select_tab(int tab){
        deselectAll();
        selected_tab=tab;
        switch (tab){
            case FRIENDS_TAB: ui.tab_friends.setBackgroundColor(getResources().getColor(R.color.icon_gray));
                                listDataToDisplay.clear();
                                for(FriendModel fm:friends){
                                    listDataToDisplay.add(fm);
                                }
                                friendAdapter.notifyDataSetChanged();
                                break;
            case FANS_TAB: ui.tab_fans.setBackgroundColor(getResources().getColor(R.color.icon_gray));
                                listDataToDisplay.clear();
                                for(FriendModel fm:fans){
                                    listDataToDisplay.add(fm);
                                }
                                friendAdapter.notifyDataSetChanged();
                                break;
        }
    }
}
