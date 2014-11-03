package com.richiejk.voyagetales;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.richiejk.voyagetales.common.Finals;

import org.w3c.dom.Text;

import java.io.File;

public class ProfileActivity extends VoyageTalesActivity {

    class UISet{
        ImageView profile_picture,settings,logout;
        TextView name,email,trips_count,friends_count,fans_count,my_name;
        Button change_pwd, edit_profile;
    }
    VoyageTalesApplication application;
    UISet ui=new UISet();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        application=(VoyageTalesApplication)getApplication();
        initUI();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    void initUI(){
        ui.profile_picture = (ImageView) findViewById(R.id.img_profile_pic);
        ui.name=(TextView)findViewById(R.id.txt_profile_user_name);
        ui.email=(TextView)findViewById(R.id.txt_profile_email_id);

        ui.trips_count=(TextView)findViewById(R.id.txt_profile_trip_count);
        ui.friends_count=(TextView)findViewById(R.id.txt_profile_friends_count);
        ui.fans_count=(TextView)findViewById(R.id.txt_profile_fans_count);

        ui.change_pwd=(Button)findViewById(R.id.btn_profile_change_pwd);
        ui.edit_profile=(Button)findViewById(R.id.btn_profile_edit_profile);

        ui.settings=(ImageView)findViewById(R.id.img_settings);
        ui.logout=(ImageView)findViewById(R.id.img_logout);

        ui.my_name=(TextView)findViewById(R.id.txt_name);



        ui.my_name.setText("("+application.getCurrent_user().getUser_name()+")");
        ui.name.setText(application.getCurrent_user().getUser_name());
        ui.email.setText(application.getCurrent_user().getEmail_id());

        ui.trips_count.setText(ui.trips_count.getText().toString().replace("%d",application.getCurrent_user().getTrips_count()+""));
        ui.friends_count.setText(ui.friends_count.getText().toString().replace("%d",application.getCurrent_user().getFriends_count()+""));
        ui.fans_count.setText(ui.fans_count.getText().toString().replace("%d",0+""));

        AQuery aq=new AQuery(this);
        aq.id(R.id.img_profile_pic).image(application.getCurrent_user().getProfile_picture());
    }


}
