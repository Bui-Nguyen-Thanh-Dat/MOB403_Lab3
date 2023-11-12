package com.example.lab3.bai3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface RequestInterface {
    @GET("/android")
    Call<JSONResponse> getJSON();
}
