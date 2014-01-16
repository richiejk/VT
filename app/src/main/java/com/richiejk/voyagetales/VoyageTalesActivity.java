package com.richiejk.voyagetales;

import android.app.Activity;
import android.graphics.Typeface;
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
import android.view.Window;
import android.widget.TextView;

import java.lang.reflect.Type;

public class VoyageTalesActivity extends Activity {
    Typeface typeface;
    Typeface titleTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        typeface= Typeface.createFromAsset(getAssets(), "fonts/VarelaRound.otf");
        titleTypeface= Typeface.createFromAsset(getAssets(),"fonts/sandbox.ttf");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.setCustomFont((ViewGroup)findViewById(android.R.id.content));
        ((TextView)findViewById(R.id.txt_title)).setTypeface(titleTypeface);

    }

    /**
     * Set custom font - Roboto Light
     *
     * Algorithm:
     *
     * 		FUNCTION Set_Font (viewGroup)
     * 			LOOP THROUGH viewGroup.children() AS child
     * 				IF child IS INSTANCE OF { TextView, EditText }
     * 					APPLY FONT FOR child
     * 				ELSE
     * 					CALL Set_Font (view)
     * 				ENDIF
     * 			END LOOP
     * 		END FUNCTION
     *
     */

    protected void setCustomFont(ViewGroup root){

        for(int i=0; i< root.getChildCount(); i++){

            View v = root.getChildAt(i);

            if(v instanceof TextView){
                ((TextView)v).setTypeface(typeface);
            } else if(v instanceof ViewGroup){
                setCustomFont((ViewGroup)v);
            }

        } // --for

    }
}
