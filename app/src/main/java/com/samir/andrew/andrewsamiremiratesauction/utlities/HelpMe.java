package com.samir.andrew.andrewsamiremiratesauction.utlities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.samir.andrew.andrewsamiremiratesauction.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ConnectException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class HelpMe {
    // static Uri.Builder builder;

    private static Context context;
    private static HelpMe instance = null;
    private Gson gson;

    public static HelpMe getInstance(Context context) {


        HelpMe.context = context;

        if (instance == null) {
            instance = new HelpMe();
        }
        return instance;
    }

    public boolean isTablet() {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public Object parseJsonToObject(String response, Class<?> modelClass) {
        if (gson == null) {
            gson = new GsonBuilder().serializeNulls().create();
        }

        try {
            return gson.fromJson(response, modelClass);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Serializes the specified object into its equivalent Json representation.
     *
     * @param object The object which Json will represent.
     * @return Json representation of src.
     */
    public String parseObjectToJson(Object object) {
        if (gson == null) {
            gson = new GsonBuilder().serializeNulls().create();
        }
        return gson.toJson(object);
    }

    public boolean isAppInstalled(String packageName) {
        try {
            //boolean whatsappFound = AndroidHelper.isAppInstalled(context, "com.whatsapp");
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public Bitmap createDrawableFromView(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay()
                .getMetrics(displayMetrics);
        view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels,
                displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }


    public void initLang(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());
    }


    public void hidekeyboard(Activity act) {
        act.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public String getVestionCode(Context c) {
        /*
        p40sdmkkmgjb1ggyadqz
        e4bbe5b7a4c1eb55652965aee885dd59bd2ee7f4
         */
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

    public void retrofironFailure(Throwable t) {

        if (t instanceof ConnectException) {
            //TODO call
//            TastyToast.makeText(context, context.getString(R.string.ntproblem), TastyToast.LENGTH_LONG, TastyToast.ERROR);
        } else {
            //TODO call

//            TastyToast.makeText(context, t.getMessage(), TastyToast.LENGTH_LONG, TastyToast.ERROR);
        }
    }


}
