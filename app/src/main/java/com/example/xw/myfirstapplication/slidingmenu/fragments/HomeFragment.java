package com.example.xw.myfirstapplication.slidingmenu.fragments;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import android.app.Fragment;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.xw.myfirstapplication.MainActivity;
import com.example.xw.myfirstapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.example.xw.myfirstapplication.facebooklike.adapter.FeedListAdapter;
import com.example.xw.myfirstapplication.facebooklike.data.FeedItem;
import com.example.xw.myfirstapplication.facebooklike.network.MyNetwork;


public class HomeFragment extends Fragment {

    //Section for facebook like start

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;
    private String URL_FEED = "http://api.androidhive.info/feed/feed.json";

    //Section for facebook like end
    private static HomeFragment mHomeFragment = null;

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
        //Section for facebook like start
        Log.v("HomeFragment", "testfacebooklike  START");

        if(rootView == null){
            Log.v("HomeFragment", "rootView == null");
        }

        listView = (ListView)rootView.findViewById(R.id.homefragment_list);
        //listView = (ListView) ((MainActivity)(MainActivity.getInstance())).findViewById(R.id.homefragment_list);
        //listView = (ListView) this.getActivity().findViewById(R.id.list);
        if(listView == null){
            Log.v("HomeFragment", "listView == null");
        }

        feedItems = new ArrayList<FeedItem>();

        if(feedItems == null || feedItems.isEmpty())
        Log.v("HomeFragment", "feedItems is null");
        else
            Log.v("HomeFragment", "feedItems is not null");
        if(MainActivity.getInstance() == null)
        Log.v("HomeFragment", "feedItems is null");
        else
            Log.v("HomeFragment", "getActivity() is not null");

        listAdapter = new FeedListAdapter(MainActivity.getInstance(), feedItems);
        //listAdapter = new FeedListAdapter(this.getActivity(), feedItems);

        if(listAdapter == null || listAdapter.isEmpty())
        Log.v("HomeFragment", "listAdapter is null");
        else
            Log.v("HomeFragment", "listAdapter is not null");
        listView.setAdapter(listAdapter);

        Log.v("HomeFragment", "testfacebooklike  after ini listView, feedItems, listAdapter");
        // These two lines not needed,
        // just to get the look of facebook (changing background color & hiding the icon)
        MainActivity.getInstance().getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3b5998")));

        //this.getActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3b5998")));
        //this.getActivity().getActionBar().setIcon(
        MainActivity.getInstance().getSupportActionBar().setIcon(


                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        Log.v("HomeFragment", "testfacebooklike  before check cache request");
        // We first check for cached request
        Cache cache = MyNetwork.getNetwork().getRequestQueue().getCache();
                //AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_FEED);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    URL_FEED, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });
            Log.v("HomeFragment", "testfacebooklike  before send request");
            // Adding request to volley request queue
            MyNetwork.getNetwork().addToRequestQueue(jsonReq);
            //AppController.getInstance().addToRequestQueue(jsonReq);
        }

        setHasOptionsMenu(true);
        Log.v("HomeFragment", "testfacebooklike  END");
        //Section for facebook like end

        return rootView;
    }


    // For facebook like start
    /**
     * Parsing json reponse and passing the data to feed view list adapter
     * */
    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("feed");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                FeedItem item = new FeedItem();
                item.setId(feedObj.getInt("id"));
                item.setName(feedObj.getString("name"));

                // Image might be null sometimes
                String image = feedObj.isNull("image") ? null : feedObj
                        .getString("image");
                item.setImge(image);
                item.setStatus(feedObj.getString("status"));
                item.setProfilePic(feedObj.getString("profilePic"));
                item.setTimeStamp(feedObj.getString("timeStamp"));

                // url might be null sometimes
                String feedUrl = feedObj.isNull("url") ? null : feedObj
                        .getString("url");
                item.setUrl(feedUrl);

                feedItems.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,  MenuInflater inflater) {
        /*getMenuInflater().inflate(R.menu.main, menu);
        return true;*/
        inflater.inflate(R.menu.homemenu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    // For facebook like End
}