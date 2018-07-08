package com.samir.andrew.andrewsamiremiratesauction.models.ModelCarsOnline;

import com.google.gson.annotations.SerializedName;

public class Cars {
    @SerializedName("carID")
    private int carid;
    @SerializedName("image")
    private String image;
    @SerializedName("descriptionAr")
    private String descriptionar;
    @SerializedName("descriptionEn")
    private String descriptionen;
    @SerializedName("imgCount")
    private int imgcount;
    @SerializedName("sharingLink")
    private String sharinglink;
    @SerializedName("sharingMsgEn")
    private String sharingmsgen;
    @SerializedName("sharingMsgAr")
    private String sharingmsgar;
    @SerializedName("mileage")
    private String mileage;
    @SerializedName("makeID")
    private int makeid;
    @SerializedName("modelID")
    private int modelid;
    @SerializedName("bodyId")
    private int bodyid;
    @SerializedName("year")
    private int year;
    @SerializedName("makeEn")
    private String makeen;
    @SerializedName("makeAr")
    private String makear;
    @SerializedName("modelEn")
    private String modelen;
    @SerializedName("modelAr")
    private String modelar;
    @SerializedName("bodyEn")
    private String bodyen;
    @SerializedName("bodyAr")
    private String bodyar;
    @SerializedName("AuctionInfo")
    private Auctioninfo auctioninfo;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescriptionar() {
        return descriptionar;
    }

    public void setDescriptionar(String descriptionar) {
        this.descriptionar = descriptionar;
    }

    public String getDescriptionen() {
        return descriptionen;
    }

    public void setDescriptionen(String descriptionen) {
        this.descriptionen = descriptionen;
    }

    public int getImgcount() {
        return imgcount;
    }

    public void setImgcount(int imgcount) {
        this.imgcount = imgcount;
    }

    public String getSharinglink() {
        return sharinglink;
    }

    public void setSharinglink(String sharinglink) {
        this.sharinglink = sharinglink;
    }

    public String getSharingmsgen() {
        return sharingmsgen;
    }

    public void setSharingmsgen(String sharingmsgen) {
        this.sharingmsgen = sharingmsgen;
    }

    public String getSharingmsgar() {
        return sharingmsgar;
    }

    public void setSharingmsgar(String sharingmsgar) {
        this.sharingmsgar = sharingmsgar;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public int getMakeid() {
        return makeid;
    }

    public void setMakeid(int makeid) {
        this.makeid = makeid;
    }

    public int getModelid() {
        return modelid;
    }

    public void setModelid(int modelid) {
        this.modelid = modelid;
    }

    public int getBodyid() {
        return bodyid;
    }

    public void setBodyid(int bodyid) {
        this.bodyid = bodyid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMakeen() {
        return makeen;
    }

    public void setMakeen(String makeen) {
        this.makeen = makeen;
    }

    public String getMakear() {
        return makear;
    }

    public void setMakear(String makear) {
        this.makear = makear;
    }

    public String getModelen() {
        return modelen;
    }

    public void setModelen(String modelen) {
        this.modelen = modelen;
    }

    public String getModelar() {
        return modelar;
    }

    public void setModelar(String modelar) {
        this.modelar = modelar;
    }

    public String getBodyen() {
        return bodyen;
    }

    public void setBodyen(String bodyen) {
        this.bodyen = bodyen;
    }

    public String getBodyar() {
        return bodyar;
    }

    public void setBodyar(String bodyar) {
        this.bodyar = bodyar;
    }

    public Auctioninfo getAuctioninfo() {
        return auctioninfo;
    }

    public void setAuctioninfo(Auctioninfo auctioninfo) {
        this.auctioninfo = auctioninfo;
    }
}
