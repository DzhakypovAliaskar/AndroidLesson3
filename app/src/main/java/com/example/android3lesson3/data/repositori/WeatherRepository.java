package com.example.android3lesson3.data.repositori;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.bumptech.glide.load.engine.Resource;
import com.example.android3lesson3.data.db.WeatherDao;
import com.example.android3lesson3.data.models.WeatherModel;
import com.example.android3lesson3.data.remote.WeatherAppApi;
import com.example.android3lesson3.ui.fragment.WeatherFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private WeatherAppApi api;
    private WeatherDao weatherDao;
    private WeatherFragment weatherFragment = new WeatherFragment();

    @Inject
    public WeatherRepository(WeatherAppApi api, WeatherDao weatherDao) {
        this.api = api;
        this.weatherDao = weatherDao;
    }

    public MutableLiveData<Resource<WeatherModel>> getWeather(String cityName) {
        MutableLiveData<Resource<WeatherModel>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(Resource.loading());
        api.getWeather(cityName, "34f284ef687268abb84bca32a3522cf7", "metric")
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            weatherDao.deleteAll();
                            mutableLiveData.setValue(Resource.(response.body()));
                            weatherDao.insertAll(response.body());
                            weatherDao.update(response.body());
                        } else {
                            mutableLiveData.setValue(Resource.error(null, response.message()));
                            weatherDao.delete(response.body());
                        }

                    }


                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                        mutableLiveData.setValue(Resource.error(null, t.getLocalizedMessage()));
                    }
                });
        return mutableLiveData;
    }

    public LiveData<WeatherModel> getAll() {
        return weatherDao.getAll();
    }
}
