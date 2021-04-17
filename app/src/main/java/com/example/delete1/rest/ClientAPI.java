package com.example.delete1.rest;

import com.example.delete1.models.DayShort;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ClientAPI {

    @GET("v1/forecast")
    public Call<DayShort> test(@Query("lat") double lat,
                                   @Query("lon") double lon,
                                   @Query("lang") String lang,
                                   @Query("limit") int limit,
                                   @Query("hours") boolean hours,
                                   @Query("extra") boolean extra,
                                   @Header("X-Yandex-API-Key") String key);

}
