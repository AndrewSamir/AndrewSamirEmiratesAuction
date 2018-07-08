package com.samir.andrew.andrewsamiremiratesauction.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.samir.andrew.andrewsamiremiratesauction.R;
import com.samir.andrew.andrewsamiremiratesauction.adapters.AdapterCars;
import com.samir.andrew.andrewsamiremiratesauction.interfaces.HandleRetrofitResp;
import com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline.Cars;
import com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline.ModelCarsOnline;
import com.samir.andrew.andrewsamiremiratesauction.retorfitconfig.HandleCalls;
import com.samir.andrew.andrewsamiremiratesauction.utlities.DataEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements HandleRetrofitResp, SwipeRefreshLayout.OnRefreshListener {

    //region fields
    AdapterCars adapterCars;
    List<Cars> carsList;
    CountDownTimer countDownTimer;
    String ticks = "";
    //endregion

    //region views

    @BindView(R.id.rvMainActivityCars)
    RecyclerView rvMainActivityCars;

    @BindView(R.id.swipeCars)
    SwipeRefreshLayout swipeCars;
    //endregion

    //region lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        carsList = new ArrayList<>();
        adapterCars = new AdapterCars(carsList, this);
        rvMainActivityCars.setLayoutManager(new GridLayoutManager(this, 1));
        rvMainActivityCars.setAdapter(adapterCars);

        HandleCalls.getInstance(this).setonRespnseSucess(this);
        callOnlineCars(ticks);
        swipeCars.setOnRefreshListener(this);
    }

    //endregion

    //region calls

    private void callOnlineCars(String tick) {

        Call call = HandleCalls.restEmiratesAuction.getClientService().callgetCarsOnline(tick);
        HandleCalls.getInstance(this).callRetrofit(call, DataEnum.callGetCarsOnline.name(), true);
    }

    //endregion

    //region call response
    @Override
    public void onResponseSuccess(String flag, Object o) {

        swipeCars.setRefreshing(false);

        JsonObject jsonObject = (JsonObject) o;
        Gson gson = new Gson();
        ModelCarsOnline modelCarsOnline = gson.fromJson(jsonObject, ModelCarsOnline.class);
        adapterCars.addAll(modelCarsOnline.getCars());

        setTimer((long) (modelCarsOnline.getRefreshinterval() * 1000), (long) 1000);
        ticks = modelCarsOnline.getTicks();
    }

    @Override
    public void onNoContent(String flag, int code) {

    }

    @Override
    public void onResponseSuccess(String flag, Object o, int position) {

    }


    //endregion

    //region functions

    @Override
    public void onRefresh() {
        callOnlineCars(ticks);
    }


    public void setTimer(Long time, Long interval) {

        countDownTimer = new CountDownTimer(time, interval) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                callOnlineCars(ticks);
            }
        }.start();
    }

    //endregion
}
