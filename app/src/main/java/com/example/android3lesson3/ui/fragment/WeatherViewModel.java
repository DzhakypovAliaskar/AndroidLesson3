package com.example.android3lesson3.ui.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.android3lesson3.common.Resource;
import com.example.android3lesson3.data.models.WeatherModel;
import com.example.android3lesson3.data.repositori.WeatherRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {
    private WeatherRepository repository;
    public LiveData<Resource<WeatherModel>> liveData;
    public LiveData<WeatherModel> localLiveData;

    @Inject
    public WeatherViewModel(WeatherRepository repository) {
        this.repository = repository;
    }

    public void getWeatherDate(String cityName){
        liveData = repository.getWeather(cityName);
    }

    public void getAll() {
        localLiveData = repository.getAll();
    }
}



