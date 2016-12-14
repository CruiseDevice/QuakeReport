package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akash on 14/12/16.
 */
public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();

    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes){
        super(context,0,earthQuakes);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        EarthQuake currentEarthQuake = getItem(position);

        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentEarthQuake.getmMagnitude());


        TextView cityNameTextView = (TextView)listItemView.findViewById(R.id.city_name);
        cityNameTextView.setText(currentEarthQuake.getmCityName());

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        dateTextView.setText(currentEarthQuake.getmDate());

        return listItemView;

    }

}
