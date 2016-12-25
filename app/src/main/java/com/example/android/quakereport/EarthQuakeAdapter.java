package com.example.android.quakereport;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

<<<<<<< HEAD
import java.text.DecimalFormat;
=======
>>>>>>> b658fa6c6491b860bc64933d9cbe702b1e1f902f
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by akash on 14/12/16.
 */
public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = "of ";

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
        String formattedMagnitude = formatMagnitude(currentEarthQuake.getmMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

        String originalLocation = currentEarthQuake.getmCityName();

        String primaryLocation;
        String offsetLocation;

<<<<<<< HEAD
=======
        String originalLocation = currentEarthQuake.getmCityName();

        String primaryLocation;
        String offsetLocation;

>>>>>>> b658fa6c6491b860bc64933d9cbe702b1e1f902f
        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else{
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView offsetLocationTextView = (TextView)listItemView.findViewById(R.id.offset_location);
        offsetLocationTextView.setText(offsetLocation);

        TextView primaryLocationTextView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);




        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentEarthQuake.getmDate());
        String formattedDate = formatDate(dateObject);

        dateTextView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);




        return listItemView;

    }

    private String formatMagnitude(double v) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(v);
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
