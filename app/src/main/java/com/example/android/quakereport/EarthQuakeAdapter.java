package com.example.android.quakereport;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        Date dateObject = new Date(currentEarthQuake.getmDate());
        String formattedDate = formatDate(dateObject);

        dateTextView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);




        return listItemView;

    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}
