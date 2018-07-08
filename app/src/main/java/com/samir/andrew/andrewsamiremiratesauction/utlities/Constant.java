package com.samir.andrew.andrewsamiremiratesauction.utlities;

import android.content.Context;
import android.content.pm.PackageManager;

import com.samir.andrew.andrewsamiremiratesauction.BuildConfig;

import java.text.DecimalFormat;


public class Constant {

    private static Context context;
    private static Constant instance = null;
    public final static String subUrl = "";
    public final static String testUrl = "";
    public final static String onlineUrl = "http://api.emiratesauction.com/v2/";

    public static Constant getInstance(Context context) {

        Constant.context = context;

        if (instance == null) {
            instance = new Constant();
        }
        return instance;
    }

    public static String getVestionCode(Context c) {

        String v = "";
        try {

            v += c.getPackageManager()
                    .getPackageInfo(c.getPackageName(), 0).versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        // Log.e("log",v);
        return v;

    }

    public final static String getBaseUrl() {

        if (BuildConfig.DEBUG) {
            return testUrl;
        } else {
            return onlineUrl;
        }
    }

}
