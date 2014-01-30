package com.richiejk.voyagetales;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class LandingActivity extends VoyageTalesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void login_now(View v){
        Intent intent=new Intent(this,DashBoardActivity.class);
        startActivity(intent);
        finish();
    }
   }
