package com.example.fataelislami.sensorkomurindo.View;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by fataelislami on 10/01/17.
 */

public class Gyroclass implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensorGyro;



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
