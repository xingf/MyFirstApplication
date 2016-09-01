package com.example.xw.myfirstapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class About extends Fragment {

    private static About mAbout = null;

    public About(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);

        return rootView;
    }
    public static About getPagesFragment(){
        if(mAbout == null){
            mAbout = new About();
        }
        return mAbout;
    }
}