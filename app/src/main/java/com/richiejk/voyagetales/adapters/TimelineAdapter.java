package com.richiejk.voyagetales.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.richiejk.voyagetales.R;
import com.richiejk.voyagetales.VoyageTalesApplication;
import com.richiejk.voyagetales.models.BlockModel;
import com.richiejk.voyagetales.models.FriendModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richie on 2/12/14.
 */
public class TimelineAdapter extends ArrayAdapter<BlockModel> {
    ArrayList<BlockModel> blocks;
    Context context;
    VoyageTalesApplication application;



    public TimelineAdapter(Context context, int textViewResourceId, ArrayList<BlockModel> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        this.blocks=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;

        application=(VoyageTalesApplication)((Activity)context).getApplication();
        Typeface typeface=application.getTypeface();
            BlockModel currentObject= blocks.get(position);
            if(row==null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row=inflater.inflate(R.layout.item_timeline,parent,false);
            }

            TextView name=(TextView)row.findViewById(R.id.txt_location_name_test_timeline);
            TextView desc=(TextView)row.findViewById(R.id.txt_location_desc_test_timeline);
            TextView time=(TextView)row.findViewById(R.id.txt_time_test_timeline);

            time.setText(currentObject.getBlockStartDateTime());
            name.setText(currentObject.getBlockTitle());
            desc.setText(currentObject.getBlockDescription());

            time.setTypeface(typeface);
            name.setTypeface(typeface);
            desc.setTypeface(typeface);
        return row;
    }

    @Override
    public int getCount() {
        return blocks.size();
    }
}
