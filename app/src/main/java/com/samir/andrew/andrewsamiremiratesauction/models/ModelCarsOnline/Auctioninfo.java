package com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline;

import com.google.gson.annotations.SerializedName;

public class Auctioninfo {
    @SerializedName("bids")
    private int bids;
    @SerializedName("endDate")
    private int enddate;
    @SerializedName("endDateEn")
    private String enddateen;
    @SerializedName("endDateAr")
    private String enddatear;
    @SerializedName("currencyEn")
    private String currencyen;
    @SerializedName("currencyAr")
    private String currencyar;
    @SerializedName("currentPrice")
    private int currentprice;
    @SerializedName("minIncrement")
    private int minincrement;
    @SerializedName("lot")
    private int lot;
    @SerializedName("priority")
    private int priority;
    @SerializedName("VATPercent")
    private int vatpercent;
    @SerializedName("isModified")
    private int ismodified;
    @SerializedName("itemid")
    private int itemid;
    @SerializedName("iCarId")
    private int icarid;
    @SerializedName("iVinNumber")
    private String ivinnumber;
    @SerializedName("finishTimeInMillis")
    private Long finishTimeInMillis;

    public int getBids() {
        return bids;
    }

    public void setBids(int bids) {
        this.bids = bids;
    }

    public int getEnddate() {
        return enddate;
    }

    public void setEnddate(int enddate) {
        this.enddate = enddate;
    }

    public String getEnddateen() {
        return enddateen;
    }

    public void setEnddateen(String enddateen) {
        this.enddateen = enddateen;
    }

    public String getEnddatear() {
        return enddatear;
    }

    public void setEnddatear(String enddatear) {
        this.enddatear = enddatear;
    }

    public String getCurrencyen() {
        return currencyen;
    }

    public void setCurrencyen(String currencyen) {
        this.currencyen = currencyen;
    }

    public String getCurrencyar() {
        return currencyar;
    }

    public void setCurrencyar(String currencyar) {
        this.currencyar = currencyar;
    }

    public int getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(int currentprice) {
        this.currentprice = currentprice;
    }

    public int getMinincrement() {
        return minincrement;
    }

    public void setMinincrement(int minincrement) {
        this.minincrement = minincrement;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getVatpercent() {
        return vatpercent;
    }

    public void setVatpercent(int vatpercent) {
        this.vatpercent = vatpercent;
    }

    public int getIsmodified() {
        return ismodified;
    }

    public void setIsmodified(int ismodified) {
        this.ismodified = ismodified;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getIcarid() {
        return icarid;
    }

    public void setIcarid(int icarid) {
        this.icarid = icarid;
    }

    public String getIvinnumber() {
        return ivinnumber;
    }

    public void setIvinnumber(String ivinnumber) {
        this.ivinnumber = ivinnumber;
    }

    public Long getFinishTimeInMillis() {
        return finishTimeInMillis;
    }

    public void setFinishTimeInMillis(Long finishTimeInMillis) {
        this.finishTimeInMillis = finishTimeInMillis;
    }
}
