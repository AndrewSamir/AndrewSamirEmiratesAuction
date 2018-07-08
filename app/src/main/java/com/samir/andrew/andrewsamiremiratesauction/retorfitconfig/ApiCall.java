package com.samir.andrew.andrewsamiremiratesauction.retorfitconfig;

import com.google.gson.JsonObject;
import com.samir.andrew.andrewsamiremiratesauction.utlities.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET(Constant.onlineUrl + "carsonline")
    Call<JsonObject> callgetCarsOnline(@Query("ticks") String ticks);

}

