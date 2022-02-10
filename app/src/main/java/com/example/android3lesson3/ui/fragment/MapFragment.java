package com.example.android3lesson3.ui.fragment;

import android.Manifest;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson3.R;
import com.example.android3lesson3.databinding.FragmentMapBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


public class MapFragment extends Fragment implements OnMapReadyCallback {

        private FragmentMapBinding binding;
        private GoogleMap gMap;
        private ArrayList<LatLng> markerList = new ArrayList<>();
        private LocationManager locationManager;

        private final String[] PERMISSIONS = new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = FragmentMapBinding.inflate(getLayoutInflater());
            binding.getRoot();

        }

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {

        }
}