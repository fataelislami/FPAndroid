package com.example.fataelislami.sensorkomurindo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fataelislami on 03/02/17.
 */

public class SensorHelper {
    private SensorManager mSensorManager;
    private Sensor mSensorGyro;
    private Sensor mSensorAccelerometer;
    private Sensor mSensorOrientasi;
    private Sensor mSensorKompas;
    public float xGyro,yGyro,zGyro, xAccel, yAccel, zAccel , xOrientasi,yOrientasi,zOrientasi;
    public float xKompas;

    public void initSensorGyro(SensorEventListener listener, SensorManager mSensorManager){
        mSensorGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorManager.registerListener(listener, mSensorGyro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void initSensorAccelerometer(SensorEventListener listener, SensorManager mSensorManager){
        mSensorAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(listener, mSensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void initSensorOrientasi(SensorEventListener listener, SensorManager mSensorManager){
        mSensorOrientasi = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorManager.registerListener(listener,mSensorOrientasi,SensorManager.SENSOR_DELAY_GAME);
    }

    public void initSensorKompas(SensorEventListener listener, SensorManager mSensorManager){
        mSensorKompas = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorManager.registerListener(listener,mSensorKompas,SensorManager.SENSOR_DELAY_GAME);

    }

    public void deinitSensor(SensorEventListener listener, SensorManager mSensorManager){
        mSensorManager.unregisterListener(listener);
    }
}
