package com.example.xw.myfirstapplication.slidingmenu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xw.myfirstapplication.R;
import com.example.xw.myfirstapplication.webviewpage.MyWebView;
import com.example.xw.myfirstapplication.webviewpage.MyWebViewClient;

public class FindPeopleFragment extends Fragment {

    private static FindPeopleFragment mFindPeopleFragment = null;
    public FindPeopleFragment(){};
    private static String url = "http://139.30.157.241/labo";
    WebView myWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_find_people, container, false);

        //For WebView Start
         myWebView = (WebView) rootView.findViewById(R.id.webview);
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new WebViewClient());

        //For WebView End



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

    public static FindPeopleFragment getFindPeopleFragment(){
        if(mFindPeopleFragment == null){
            mFindPeopleFragment = new FindPeopleFragment();
        }
        return mFindPeopleFragment;
    }
}
