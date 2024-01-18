package com.example.dependencyinjection.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dependencyinjection.databinding.FragmentHomeBinding;
import com.example.dependencyinjection.ui.home.di.Engine;
import com.example.dependencyinjection.ui.home.di.Plane;
import com.example.dependencyinjection.ui.home.di.PlaneType;
import com.example.dependencyinjection.ui.home.di.Wing;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        Engine e = new Engine();
        Wing w = new Wing();
        PlaneType p = new PlaneType();
        Plane plane = new Plane(e, w, p);
        plane.takeOff();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}