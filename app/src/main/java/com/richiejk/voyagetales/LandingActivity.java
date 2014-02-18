package com.richiejk.voyagetales;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.richiejk.voyagetales.common.CommonUtils;
import com.richiejk.voyagetales.common.Finals;
import com.richiejk.voyagetales.common.ImageManager;
import com.richiejk.voyagetales.data.DBHandler;
import com.richiejk.voyagetales.models.UserModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LandingActivity extends VoyageTalesActivity {


    class UISet{
        EditText username,password;
        TextView forgotPassword;
        Button login,register;
        ImageView temp_me;
        CheckBox rememberMe;
        ProgressDialog progressDialog;
    }

    UISet ui=new UISet();
    VoyageTalesApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application=(VoyageTalesApplication)getApplication();
        Log.i("LOG_STATUS_CODE",CommonUtils.checkIfLoginIsSaved(this)+"");
        int status=CommonUtils.checkIfLoginIsSaved(this);
        if(status==Finals.SHARED_PREFS_IS_LOGGED_IN_TRUE){
            Log.i("LOG_STATUS","TRUE");
            DBHandler dbHandler=new DBHandler(this);
            UserModel currentUser=dbHandler.getUser(CommonUtils.getCurrentUserId(this));
            currentUser.setFriends(new ArrayList<UserModel>());
            application.setCurrent_user(currentUser);

            Intent intent=new Intent(this,DashBoardActivity.class);
            startActivity(intent);
            finish();
        }else{
            setContentView(R.layout.activity_landing);
            initUI();
            setListeners();
        }


    }

    public void login_now(View v){
        int error=0;
        if(ui.username.getText().toString().trim().length()==0){
            ui.username.setError("Please enter your email id");
            error=1;
        }
        if(ui.password.getText().toString().trim().length()==0){
            ui.password.setError("Please enter your password");
            error=1;
        }
        if(error==0){
          ui.progressDialog.show();
          doLogin();
        }

    }

    public void initUI(){
        ui.username=(EditText)findViewById(R.id.editText_landing_username);
        ui.password=(EditText)findViewById(R.id.editText_landing_password);
        ui.forgotPassword=(TextView)findViewById(R.id.txt_landing_forgot_pwd);
        ui.login=(Button)findViewById(R.id.btn_landing_sign_in);
        ui.register=(Button)findViewById(R.id.btn_landing_register);
        ui.rememberMe=(CheckBox)findViewById(R.id.checkBox_landing_remember_me);

        ui.temp_me=(ImageView)findViewById(R.id.temp_me);

        ui.progressDialog=new ProgressDialog(this);
        ui.progressDialog.setCancelable(false);
        ui.progressDialog.setTitle("Signing in");
        ui.progressDialog.setMessage("Signing you in. Please be patient");
    }

    public void setListeners(){

        ui.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LandingActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ui.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void doLogin(){
        //todo login logic
        if(ui.rememberMe.isChecked()){
            CommonUtils.changeLoginSavedStatus(this, Finals.SHARED_PREFS_IS_LOGGED_IN_TRUE);
            Log.i("LOG_STATUS_CODE_INITIATOR","START");
        }

        ui.progressDialog.hide();


     //   int user_id=1;
        DBHandler dbHandler=new DBHandler(this);
        UserModel currentUser=new UserModel("richie",ui.username.getText().toString(),"http://www.unmatchedstyle.com/wp-content/uploads/2010/11/user.jpg", 0,0, 0, 0, 0);
        currentUser.setFriends(new ArrayList<UserModel>());

        int id=dbHandler.insertUser(currentUser);

        CommonUtils.setCurrentUserId(this,id);
        application.setCurrent_user(currentUser);


        boolean memCache = true;
        boolean fileCache = true;
        AQuery aq=new AQuery(this);
        aq.id(R.id.temp_me).image(currentUser.getProfile_picture(), memCache, fileCache);

        Intent intent=new Intent(this,DashBoardActivity.class);
        startActivity(intent);
        finish();
    }

    void downloadImage(){
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                ImageManager.DownloadFromUrl(application.getCurrent_user().getProfile_picture(),"me.jpg");
                return null;
            }
        }.execute(null);
    }


   }
