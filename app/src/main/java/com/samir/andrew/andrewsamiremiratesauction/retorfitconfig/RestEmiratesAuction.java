package com.samir.andrew.andrewsamiremiratesauction.retorfitconfig;

import android.content.Context;

import com.samir.andrew.andrewsamiremiratesauction.utlities.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestEmiratesAuction {

    private static RestEmiratesAuction instance;
    private static ApiCall apiService;
    private static Context mcontext;

    private RestEmiratesAuction() {


        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(5, TimeUnit.SECONDS);

        //comment start to create signed apk

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

        //comment end

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();
                Request newRequest;

                newRequest = request.newBuilder()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .method(request.method(), request.body())
                        .build();
                return chain.proceed(newRequest);


            }
        });

        OkHttpClient httpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.onlineUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        apiService = retrofit.create(ApiCall.class);
    }

    public static RestEmiratesAuction getInstance(Context context) {
        mcontext = context;
        if (instance == null) {
            instance = new RestEmiratesAuction();
        }
        return instance;
    }

    public ApiCall getClientService() {

        return apiService;
    }
}