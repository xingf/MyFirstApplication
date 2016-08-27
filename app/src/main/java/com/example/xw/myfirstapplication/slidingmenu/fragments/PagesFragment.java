package com.example.xw.myfirstapplication.slidingmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class PagesFragment extends Fragment {

    private static PagesFragment mPagesFragment = null;

    public PagesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);

        return rootView;
    }
    public static PagesFragment getPagesFragment(){
        if(mPagesFragment == null){
            mPagesFragment = new PagesFragment();
        }
        return mPagesFragment;
    }
}