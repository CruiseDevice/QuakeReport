package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> a1756f82c04b552842328cb22c379e3380cde0f2
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
<<<<<<< HEAD
=======
=======
import org.w3c.dom.Text;

<<<<<<< HEAD
import java.text.DecimalFormat;
=======
>>>>>>> b658fa6c6491b860bc64933d9cbe702b1e1f902f
>>>>>>> 5e53ec65fe964275bdfcc19028180c20d4f26d79
>>>>>>> a1756f82c04b552842328cb22c379e3380cde0f2
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


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable


        TextView magnitudeTextView = (TextView)listItemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentEarthQuake.getmMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

<<<<<<< HEAD
        GradientDrawable magnitudeCircle  = (GradientDrawable)magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getmMagnitude());
        //set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

=======
<<<<<<< HEAD
        GradientDrawable magnitudeCircle  = (GradientDrawable)magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getmMagnitude());
        //set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = currentEarthQuake.getmCityName();

        String primaryLocation;
        String offsetLocation;

=======
        String originalLocation = currentEarthQuake.getmCityName();

        String primaryLocation;
        String offsetLocation;

<<<<<<< HEAD
=======
>>>>>>> a1756f82c04b552842328cb22c379e3380cde0f2
        String originalLocation = currentEarthQuake.getmCityName();

        String primaryLocation;
        String offsetLocation;

<<<<<<< HEAD
=======
>>>>>>> b658fa6c6491b860bc64933d9cbe702b1e1f902f
>>>>>>> 5e53ec65fe964275bdfcc19028180c20d4f26d79
>>>>>>> a1756f82c04b552842328cb22c379e3380cde0f2
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
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double v) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(v);
    }
<<<<<<< HEAD
=======

    private String formatMagnitude(double v) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(v);
    }
>>>>>>> a1756f82c04b552842328cb22c379e3380cde0f2

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}
