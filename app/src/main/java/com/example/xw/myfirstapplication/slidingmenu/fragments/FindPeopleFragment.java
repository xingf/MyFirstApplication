package com.example.xw.myfirstapplication.slidingmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class FindPeopleFragment extends Fragment {

    private static FindPeopleFragment mFindPeopleFragment = null;
    public FindPeopleFragment(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);

        return rootView;
    }

    public static FindPeopleFragment getFindPeopleFragment(){
        if(mFindPeopleFragment == null){
            mFindPeopleFragment = new FindPeopleFragment();
        }
        return mFindPeopleFragment;
    }
}
