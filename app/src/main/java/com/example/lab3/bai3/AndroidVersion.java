package com.example.lab3.bai3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AndroidVersion {
    @SerializedName("ver")
    @Expose
    private String ver;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("api")
    @Expose
    private String api;
    public String getVer() {
        return ver;
    }
    public String getName() {
        return name;
    }
    public String getApi() {
        return api;
    }
}
