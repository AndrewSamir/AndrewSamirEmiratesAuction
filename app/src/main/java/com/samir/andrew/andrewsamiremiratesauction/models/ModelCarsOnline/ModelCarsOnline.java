package com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andre on 07-Jul-18.
 */

public class ModelCarsOnline {


    @SerializedName("alertEn")
    private String alerten;
    @SerializedName("alertAr")
    private String alertar;
    @SerializedName("Error")
    private Error error;
    @SerializedName("RefreshInterval")
    private int refreshinterval;
    @SerializedName("Ticks")
    private String ticks;
    @SerializedName("count")
    private int count;
    @SerializedName("endDate")
    private int enddate;
    @SerializedName("sortOption")
    private String sortoption;
    @SerializedName("sortDirection")
    private String sortdirection;
    @SerializedName("Cars")
    private List<Cars> cars;

    public String getAlerten() {
        return alerten;
    }

    public void setAlerten(String alerten) {
        this.alerten = alerten;
    }

    public String getAlertar() {
        return alertar;
    }

    public void setAlertar(String alertar) {
        this.alertar = alertar;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public int getRefreshinterval() {
        return refreshinterval;
    }

    public void setRefreshinterval(int refreshinterval) {
        this.refreshinterval = refreshinterval;
    }

    public String getTicks() {
        return ticks;
    }

    public void setTicks(String ticks) {
        this.ticks = ticks;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getEnddate() {
        return enddate;
    }

    public void setEnddate(int enddate) {
        this.enddate = enddate;
    }

    public String getSortoption() {
        return sortoption;
    }

    public void setSortoption(String sortoption) {
        this.sortoption = sortoption;
    }

    public String getSortdirection() {
        return sortdirection;
    }

    public void setSortdirection(String sortdirection) {
        this.sortdirection = sortdirection;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setCars(List<Cars> cars) {
        this.cars = cars;
    }
}
