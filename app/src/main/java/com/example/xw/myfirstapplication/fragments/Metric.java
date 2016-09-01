package com.example.xw.myfirstapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class Metric extends Fragment {

    private static Metric mMetric = null;
    public Metric(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);





        return rootView;
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && MyWebView.canGoBack()) {
            MyWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }*/

    public static Metric getFindPeopleFragment(){
        if(mMetric == null){
            mMetric = new Metric();
        }
        return mMetric;
    }
}
