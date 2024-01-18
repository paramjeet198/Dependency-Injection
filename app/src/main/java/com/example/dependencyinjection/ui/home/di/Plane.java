package com.example.dependencyinjection.ui.home.di;

import android.util.Log;

public class Plane {

    private Engine e;
    private Wing w;

    private PlaneType p;

    public Plane(Engine e, Wing w, PlaneType p) {
        this.e = e;
        this.w = w;
        this.p = p;
    }

    public void takeOff() {
        Log.v("TAG", "Take OFF.......");
    }

}
