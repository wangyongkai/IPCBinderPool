package com.example.zr.ipcdemo.application;

import android.app.Application;
import android.util.Log;

/**
 * Created by zr on 16/4/2.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

//        System.out.println("create");
        Log.d("zr", "onCreate");
    }
}
