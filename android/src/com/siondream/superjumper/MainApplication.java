package com.siondream.superjumper;

import android.app.Application;
import com.siondream.superjumper.android.R;
//import com.google.android.gms.analytics.GoogleAnalytics;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //GoogleAnalytics.getInstance(this).newTracker(R.xml.app_tracker_config);
    }

}