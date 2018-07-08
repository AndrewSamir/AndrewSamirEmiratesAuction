package com.samir.andrew.andrewsamiremiratesauction.application;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.support.multidex.MultiDexApplication;
import android.util.Base64;
import android.util.Log;

import com.samir.andrew.andrewsamiremiratesauction.R;
import com.samir.andrew.andrewsamiremiratesauction.utlities.SharedPrefHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;


public class MyApplication extends MultiDexApplication {
    Configuration config;
    Locale locale;

    @Override
    public void onCreate() {
        super.onCreate();

        initLang();
    }

    private void initLang() {

//        String lang = "ar";
        String lang = "en";
        SharedPrefHelper.getInstance(getApplicationContext()).setLang(lang);
        locale = new Locale(lang);
        Locale.setDefault(locale);
        config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

}
