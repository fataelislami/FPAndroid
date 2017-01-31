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

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Magnetometer extends AppCompatActivity implements SensorEventListener{
    @BindView(R.id.MagnetX)
    TextView MagnetX;
    @BindView(R.id.MagnetY)
    TextView MagnetY;
    @BindView(R.id.MagnetZ)
    TextView MagnetZ;
    @BindView(R.id.TombolMagnet)
    Button   TombolPindah;
    private SensorManager mSensorManager;
    private Sensor mSensorMagnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetometer);
        ButterKnife.bind(this);
        mSensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorMagnet=mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mSensorManager.registerListener(this, mSensorMagnet, SensorManager.SENSOR_DELAY_NORMAL);

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorMagnet, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        if(sensorEvent.accuracy==SensorManager.SENSOR_STATUS_UNRELIABLE){
            return;
        }
        MagnetX.setText(Float.toString(x));
        MagnetY.setText(Float.toString(y));
        MagnetZ.setText(Float.toString(z));

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @OnClick(R.id.TombolMagnet)
    public void Klik(){
        Intent pindah =new Intent(this, MainActivity.class);
        startActivity(pindah);
    }
}
