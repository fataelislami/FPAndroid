package com.example.fataelislami.sensorkomurindo.View;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.fataelislami.sensorkomurindo.MainActivity;
import com.example.fataelislami.sensorkomurindo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Gyroscope extends AppCompatActivity implements SensorEventListener {
    
    @BindView(R.id.Gyro_X)
    TextView gyroX;
    @BindView(R.id.Gyro_Y)
    TextView gyroY;
    @BindView(R.id.Gyro_Z)
    TextView gyroZ;
    @BindView(R.id.button2) Button tombol2;
    private SensorManager mSensorManager;
    private Sensor mSensorGyro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        ButterKnife.bind(this);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorGyro = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mSensorManager.registerListener(this, mSensorGyro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorGyro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }
@Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       float x = sensorEvent.values[0];
       float y = sensorEvent.values[1];
       float z = sensorEvent.values[2];
        if(sensorEvent.accuracy==SensorManager.SENSOR_STATUS_UNRELIABLE){
            return;
        }


        gyroX.setText(Float.toString(x));
        gyroY.setText(Float.toString(y));
        gyroZ.setText(Float.toString(z));

    }





    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @OnClick(R.id.button2)
    public void pindaheuy(){
        Intent pindah =new Intent(this, MainActivity.class);
        startActivity(pindah);
    }
}
