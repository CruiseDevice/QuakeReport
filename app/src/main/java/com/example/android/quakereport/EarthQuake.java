package com.example.android.quakereport;

/**
 * Created by akash on 14/12/16.
 */
public class EarthQuake {
    private String mMagnitude;
    private String mCityName;
    private long mDate;

    public EarthQuake(String mMag, String mCity, long mD){
        mMagnitude = mMag;
        mCityName = mCity;
        mDate = mD;
    }

    public String getmMagnitude(){
        return mMagnitude;
    }
    public String getmCityName(){
        return mCityName;
    }
    public long getmDate(){
        return mDate;
    }


}
