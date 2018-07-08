package com.samir.andrew.andrewsamiremiratesauction.utlities;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefHelper {
    private static Context context;
    private static SharedPrefHelper instance = null;
    private static SharedPreferences prefs = null;
    private static SharedPreferences.Editor editor;

    public static SharedPrefHelper getInstance(Context context) {
        SharedPrefHelper.context = context;

        if (instance == null) {
            instance = new SharedPrefHelper();
            SharedPrefHelper.prefs = context.getSharedPreferences(DataEnum.SharedPref.name(), MODE_PRIVATE);
        }
        return instance;
    }

    public void setLang(String lang) {
        editor = context.getSharedPreferences(DataEnum.SharedPref.name(), MODE_PRIVATE).edit();
        editor.putString(DataEnum.Lang.name(), lang);
        editor.apply();
    }

    public String getLang() {
        return prefs.getString(DataEnum.Lang.name(), "en");
    }


}
