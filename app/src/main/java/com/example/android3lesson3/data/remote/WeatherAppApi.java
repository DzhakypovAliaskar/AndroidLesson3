package com.example.android3lesson3.data.remote;


import com.example.android3lesson3.data.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAppApi {

    @GET("weather")
    Call<WeatherModel> getWeather(@Query("q") String cityName,
                                  @Query("appid") String appid,
                                  @Query("units") String units);
}
