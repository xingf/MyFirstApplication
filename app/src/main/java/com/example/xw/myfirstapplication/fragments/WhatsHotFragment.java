package com.example.xw.myfirstapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class WhatsHotFragment extends Fragment {

    private static WhatsHotFragment mWhatsHotFragment = null;
    public WhatsHotFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);

        return rootView;
    }

    public static WhatsHotFragment getWhatsHotFragment(){
        if(mWhatsHotFragment == null){
            mWhatsHotFragment = new WhatsHotFragment();
        }
        return mWhatsHotFragment;
    }
}