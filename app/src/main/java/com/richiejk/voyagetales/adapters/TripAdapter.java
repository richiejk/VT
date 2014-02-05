package com.richiejk.voyagetales.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;
import com.richiejk.voyagetales.R;
import com.richiejk.voyagetales.VoyageTalesApplication;
import com.richiejk.voyagetales.models.FriendModel;
import com.richiejk.voyagetales.models.TripModel;

import java.util.ArrayList;

/**
 * Created by richie on 2/3/14.
 */
public class TripAdapter extends ArrayAdapter<TripModel> {

    Context context;
    ArrayList<TripModel> trips;
    int textViewId;

    public TripAdapter(Context context, int textViewResourceId, ArrayList<TripModel> objects) {
        super(context, textViewResourceId, objects);
        this.trips=objects;
        this.context=context;
        this.textViewId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VoyageTalesApplication application=(VoyageTalesApplication)((Activity)context).getApplication();
        View row=convertView;
        TripModel currentObject= trips.get(position);

        if(row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.item_trips_list,parent,false);
        }

        TextView name=(TextView)row.findViewById(R.id.txt_item_trips_list_name);
        name.setText(currentObject.getTrip_name());
        name.setTypeface(application.getTypeface());
        ImageView pic=(ImageView)row.findViewById(R.id.img_trips_list_item_bg);
        AQuery aQuery=new AQuery(context);
        boolean memCache = true;

        ImageOptions options = new ImageOptions();

        options.fileCache=true;
        boolean fileCache = true;
        aQuery.id(pic).image(currentObject.getTrip_cover_picture(),options);

        return row;
    }

    @Override
    public int getCount() {
        return trips.size();
    }
}
