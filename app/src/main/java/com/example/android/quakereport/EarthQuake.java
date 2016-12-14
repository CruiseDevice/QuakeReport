package com.example.android.quakereport;

/**
 * Created by akash on 14/12/16.
 */
public class EarthQuake {
    private String mMagnitude;
    private String mCityName;
    private String mDate;

    public EarthQuake(String mMag, String mCity,String mD){
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
    public String getmDate(){
        return mDate;
    }


}
