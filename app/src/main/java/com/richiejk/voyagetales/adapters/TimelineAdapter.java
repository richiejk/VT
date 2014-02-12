package com.richiejk.voyagetales.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    public TimelineAdapter(Context context, int textViewResourceId, ArrayList<BlockModel> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        this.blocks=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VoyageTalesApplication application=(VoyageTalesApplication)((Activity)context).getApplication();
        View row=convertView;
        BlockModel currentObject= blocks.get(position);

        if(row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.item_timeline,parent,false);
        }

        TextView name=(TextView)row.findViewById(R.id.txt_location_name_test_timeline);
        TextView desc=(TextView)row.findViewById(R.id.txt_location_desc_test_timeline);

        name.setText(currentObject.getBlockTitle());
        desc.setText(currentObject.getBlockDescription());
        return row;
    }

    @Override
    public int getCount() {
        return blocks.size();
    }
}
