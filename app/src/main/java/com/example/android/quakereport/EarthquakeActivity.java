/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getSimpleName();

    private static final String SAMPLE_JSON_RESPONSE = " http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    private EarthQuakeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        /*final ArrayList<EarthQuake> earthquakes = new ArrayList<EarthQuake>();
        earthquakes.add(new EarthQuake("7.2","San Francisco","Feb 2,2016"));
        earthquakes.add(new EarthQuake("6.1","London","July 20,2015"));
        earthquakes.add(new EarthQuake("3,9","Tokyo","Nov 10,2014"));
        earthquakes.add(new EarthQuake("5.4","Mexico City","May 3,2014"));
        earthquakes.add(new EarthQuake("2.8","Moscow","Jan 31,2013"));
        earthquakes.add(new EarthQuake("4,9","Rio de Janeiro","Aug 19,2012"));
        earthquakes.add(new EarthQuake("1.6","Paris","Oct 30,2011"));
        */

      //  ArrayList<EarthQuake>earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
       // ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                //this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        //earthquakeListView.setAdapter(adapter);

        //Custom ArrayAdapter

       mAdapter = new EarthQuakeAdapter(this,new ArrayList<EarthQuake>());



        ListView earthquakeListView = (ListView)findViewById(R.id.list);
        earthquakeListView.setAdapter(mAdapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthQuake currentEarthquake = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
        EarthQuakeAsyncTask task = new EarthQuakeAsyncTask();
        task.execute(SAMPLE_JSON_RESPONSE);
    }

    private class EarthQuakeAsyncTask extends AsyncTask<String,Void,List<EarthQuake>>{

        @Override
        protected List<EarthQuake> doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }

            List<EarthQuake> result = QueryUtils.fetchEarthquakeData(strings[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<EarthQuake> data){
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }
}
