package com.samir.andrew.andrewsamiremiratesauction.retorfitconfig;

import android.app.Dialog;

import android.content.Context;

import com.google.gson.JsonObject;
import com.samir.andrew.andrewsamiremiratesauction.interfaces.HandleRetrofitResp;
import com.samir.andrew.andrewsamiremiratesauction.interfaces.HandleRetrofitRespAdapter;
import com.samir.andrew.andrewsamiremiratesauction.utlities.HelpMe;


import developer.mokadim.projectmate.dialog.IndicatorStyle;
import developer.mokadim.projectmate.dialog.ProgressDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HandleCalls {
    private static Context context;
    private static HandleCalls instance = null;
    public static RestEmiratesAuction restEmiratesAuction;
    private HandleRetrofitResp onRespnse;
    private HandleRetrofitRespAdapter onRespnseAdapter;

    public static HandleCalls getInstance(Context context) {

        HandleCalls.context = context;

        if (instance == null) {
            instance = new HandleCalls();
            restEmiratesAuction = RestEmiratesAuction.getInstance(context);
        }
        return instance;
    }

    public void setonRespnseSucess(HandleRetrofitResp onRespnseSucess) {
        this.onRespnse = onRespnseSucess;
    }

    public void setonRespnseSucessApapter(HandleRetrofitRespAdapter onRespnseAdapter) {
        this.onRespnseAdapter = onRespnseAdapter;
    }


    public <T> void callRetrofit(Call<JsonObject> call, final String flag, final Boolean showLoading) {

        final Dialog progressDialog = new ProgressDialog(context, IndicatorStyle.BallBeat).show();
        progressDialog.show();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {
                    onRespnse.onResponseSuccess(flag, response.body());
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progressDialog.dismiss();
                HelpMe.getInstance(context).retrofironFailure(t);
            }
        });

    }

}