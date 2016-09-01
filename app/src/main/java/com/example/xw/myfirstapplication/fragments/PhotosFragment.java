package com.example.xw.myfirstapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xw.myfirstapplication.R;

public class PhotosFragment extends Fragment {

    private static PhotosFragment mPhotosFragment = null;
    public PhotosFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        return rootView;
    }
    public static PhotosFragment getPhotosFragment(){
        if(mPhotosFragment == null){
            mPhotosFragment = new PhotosFragment();
        }
        return mPhotosFragment;
    }
}
