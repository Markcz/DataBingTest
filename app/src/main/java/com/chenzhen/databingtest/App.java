package com.chenzhen.databingtest;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by chenzhen on 2018/3/23.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
