package com.example.xw.myfirstapplication;

import android.app.Application;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/27.
 */
public class MyApplication extends Application {
    public static MyApplication mApplication;

    @Override
    public void onCreate(){
        Log.v("MyApplication", "onCreate()  START");
        super.onCreate();
        mApplication = this;
        Log.v("MyApplication", "onCreate()  END");
    }

    public static MyApplication getInstance(){
        return mApplication;
    }

    public static String getSuperSimpleName(){
        return Application.class.getSimpleName();
    }
}
