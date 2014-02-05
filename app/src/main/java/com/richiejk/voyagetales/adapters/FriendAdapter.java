package com.richiejk.voyagetales.adapters;

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
import com.richiejk.voyagetales.models.FriendModel;
import com.richiejk.voyagetales.models.UserModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richie on 2/3/14.
 */
public class FriendAdapter extends ArrayAdapter<FriendModel> {

    Context context;
    ArrayList<FriendModel> friends;
    int textViewId;

    public FriendAdapter(Context context, int textViewResourceId, ArrayList<FriendModel> objects) {
        super(context, textViewResourceId, objects);
        this.friends=objects;
        this.context=context;
        this.textViewId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        FriendModel currentObject= friends.get(position);

        if(row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.item_friends_list,parent,false);
        }

        TextView name=(TextView)row.findViewById(R.id.txt_item_friends_list_name);
        name.setText(currentObject.getUser_name());

        ImageView pic=(ImageView)row.findViewById(R.id.img_item_friends_list_pic);
        AQuery aQuery=new AQuery(context);
        boolean memCache = true;

        ImageOptions options = new ImageOptions();

        options.fileCache=true;
        boolean fileCache = true;
        aQuery.id(pic).image(currentObject.getProfile_picture(),options);

        return row;
    }

    @Override
    public int getCount() {
        return friends.size();
    }
}
