package com.example.xw.myfirstapplication;

import android.content.res.Configuration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.xw.myfirstapplication.slidingmenu.NavigationDrawer;

public class MainActivity extends AppCompatActivity {

    private NavigationDrawer navigationDrawer;

    private static MainActivity mMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("MainActivity", "onCreate() START");
        super.onCreate(savedInstanceState);
        mMainActivity = this;
        setContentView(R.layout.activity_main);

        addNavigationDrawer(new NavigationDrawer(this));
        navigationDrawer.display(savedInstanceState);

        Log.v("MainActivity", "onCreate() END");



    }

    public static MainActivity getInstance(){
        return mMainActivity;
    }



    private void addNavigationDrawer(NavigationDrawer navigationDrawer){
        this.navigationDrawer = navigationDrawer;
        navigationDrawer.init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (navigationDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = navigationDrawer.getDrawerLayout().isDrawerOpen(navigationDrawer.getDrawerList());
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
       getSupportActionBar().setTitle(title);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        navigationDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        navigationDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }

}
