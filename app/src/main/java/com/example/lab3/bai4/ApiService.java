package com.example.lab3.bai4;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("/contacts")
    Call<ContactList> getMyJSON();
}
