package com.example.fataelislami.sensorkomurindo.Presenter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by fataelislami on 31/01/17.
 */

public class AkseleroClass implements SensorEventListener {
    Context context;
    float x,y,z;
    public AkseleroClass(Context context)  {
        this.context = context;
        SensorManager manager =
                (SensorManager)context.getSystemService( Context.SENSOR_SERVICE );
        Sensor accel = manager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );
        manager.registerListener( this, accel, SensorManager.SENSOR_DELAY_GAME );


    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public void onSensorChanged(Class<SensorEvent> sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
