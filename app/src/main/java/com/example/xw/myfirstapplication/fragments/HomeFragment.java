package com.example.xw.myfirstapplication.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.app.Fragment;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.xw.myfirstapplication.MainActivity;
import com.example.xw.myfirstapplication.R;

import java.util.List;

import com.example.xw.myfirstapplication.facebooklike.adapter.FeedListAdapter;
import com.example.xw.myfirstapplication.facebooklike.data.FeedItem;
import com.example.xw.myfirstapplication.myWebView.MyWebViewClient;


public class HomeFragment extends Fragment {

    private static HomeFragment mHomeFragment = null;
    private static Metric mMetric = null;
    private static String url = "http://139.30.154.159/labo/";

    WebView myWebView;
    public HomeFragment(){}

    public static HomeFragment getHomeFragment(){
        if(mHomeFragment == null){
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout rootView = (RelativeLayout) inflater.inflate(R.layout.fragment_home, container, false);

        //For WebView Start
        /*myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new MyWebViewClient());*/
        myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new MyWebViewClient());

        //For WebView End
        return rootView;
    }



}