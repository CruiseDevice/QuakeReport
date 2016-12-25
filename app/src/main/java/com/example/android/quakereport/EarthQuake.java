package com.example.android.quakereport;

/**
 * Created by akash on 14/12/16.
 */
public class EarthQuake {
    private double mMagnitude;
    private String mCityName;
    private long mDate;

    public EarthQuake(double mMag, String mCity, long mD){
        mMagnitude = mMag;
        mCityName = mCity;
        mDate = mD;
    }

    public double getmMagnitude(){
        return mMagnitude;
    }
    public String getmCityName(){
        return mCityName;
    }
    public long getmDate(){
        return mDate;
    }


}
