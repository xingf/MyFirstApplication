package com.example.xw.myfirstapplication.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.xw.myfirstapplication.R;
import java.util.ArrayList;
import com.example.xw.myfirstapplication.slidingmenu.adapter.NavDrawerListAdapter;
import com.example.xw.myfirstapplication.slidingmenu.fragments.CommunityFragment;
import com.example.xw.myfirstapplication.slidingmenu.fragments.FindPeopleFragment;
import com.example.xw.myfirstapplication.slidingmenu.fragments.HomeFragment;
import com.example.xw.myfirstapplication.slidingmenu.fragments.PagesFragment;
import com.example.xw.myfirstapplication.slidingmenu.fragments.PhotosFragment;
import com.example.xw.myfirstapplication.slidingmenu.fragments.WhatsHotFragment;
import com.example.xw.myfirstapplication.slidingmenu.model.NavDrawerItem;


public class NavigationDrawer {


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    private AppCompatActivity cxt;

    public NavigationDrawer(AppCompatActivity cxt){
        this.cxt = cxt;
    }
    @SuppressWarnings("ResourceType")

    public void init() {

        mTitle = mDrawerTitle = cxt.getTitle();

        // load slide menu items
        navMenuTitles = cxt.getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = cxt.getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) cxt.findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) cxt.findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));


        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(cxt.getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        cxt.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cxt.getSupportActionBar().setHomeButtonEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        // getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(cxt, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                cxt.getSupportActionBar().setTitle(mTitle);
                //getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                cxt.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                cxt.getSupportActionBar().setTitle(mDrawerTitle);
                //getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                cxt.invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);


    }

    public void display(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }

    /**
     * Slide menu item click listener
     */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    public ActionBarDrawerToggle getDrawerToggle(){
        return  mDrawerToggle;
    }

    public DrawerLayout getDrawerLayout(){
        return mDrawerLayout;
    }

    public ListView getDrawerList(){
        return mDrawerList;
    }

    public String getNavMenuTitle(int position){
        return navMenuTitles[position];
    }

    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment =  HomeFragment.getHomeFragment();
                break;
            case 1:
                fragment = FindPeopleFragment.getFindPeopleFragment();
                break;
            case 2:
                fragment = PhotosFragment.getPhotosFragment();
                break;
            case 3:
                fragment = CommunityFragment.getCommunityFragment();
                break;
            case 4:
                fragment = PagesFragment.getPagesFragment();
                break;
            case 5:
                fragment = WhatsHotFragment.getWhatsHotFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = cxt.getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            cxt.setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

}


