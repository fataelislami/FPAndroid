package com.example.fataelislami.sensorkomurindo.View;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fataelislami.sensorkomurindo.R;

public class Orientasi extends AppCompatActivity {

    private TextView txtView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientasi);
        txtView = (TextView) findViewById(R.id.txtView);
        txtView.setTextColor(Color.BLACK);


        SensorManager sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(new CustomOrientationListener(), sensor,
                SensorManager.SENSOR_DELAY_GAME);

    }

    class CustomOrientationListener implements SensorEventListener {

        public CustomOrientationListener() {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values;
            if(event.sensor.getType() == Sensor.TYPE_ORIENTATION){
                values = event.values;
                txtView.setText(values[0]+"  "+values[1]+"  "+values[2]);
                txtView.invalidate();
            }

        }

    }
}
