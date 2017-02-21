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
import android.widget.Toast;

import com.example.fataelislami.sensorkomurindo.MainActivity;
import com.example.fataelislami.sensorkomurindo.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Acelerometer extends AppCompatActivity implements SensorEventListener {
    @BindView(R.id.AcelX)
    TextView AcelX;
    @BindView(R.id.AcelY)
    TextView AcelY;
    @BindView(R.id.AcelZ)
    TextView AcelZ;
    @BindView(R.id.TombolAcel)
    Button Tombol;
    @BindView(R.id.keterangan)
    TextView Keterangan;
    private SensorManager mSensorManager;
    private Sensor mSensorAcel;
    private final float NOISE = (float) 2.0;
    private boolean mInitialized;
    float posisiX,posisiY,posisiZ;
    public float x,y,z;
    public float deltaX,deltaY,deltaZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometer);
        mSensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorAcel=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ButterKnife.bind(this);
        mInitialized=false;
    }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mSensorAcel, SensorManager.SENSOR_DELAY_NORMAL);

    }
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x=sensorEvent.values[0];
        y=sensorEvent.values[1];
        z=sensorEvent.values[2];
        if (!mInitialized) {
            posisiX = x;
            posisiY = y;
            posisiZ = z;
            AcelX.setText("0.0");
            AcelY.setText("0.0");
            AcelZ.setText("0.0");
            mInitialized = true;
        }
        else {
            deltaX = Math.abs(posisiX - x);
            deltaY = Math.abs(posisiY - y);
            deltaZ = Math.abs(posisiZ - z);
            if (deltaX < NOISE) deltaX = (float)0.0;
            if (deltaY < NOISE) deltaY = (float)0.0;
            if (deltaZ < NOISE) deltaZ = (float)0.0;
            posisiX = x;
            posisiY = y;
            posisiZ = z;
            AcelX.setText(Float.toString(deltaX));
            AcelY.setText(Float.toString(deltaY));
            AcelZ.setText(Float.toString(deltaZ));
        if(deltaX>deltaY){
            Keterangan.setText("Kiri Kanan");
        }
            else if(deltaY>deltaX){
            Keterangan.setText("Atas Bawah");
        }
            else if(deltaZ>deltaX){
            Keterangan.setText("Luar Dalam");
        }
        }


        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @OnClick(R.id.TombolAcel)
    public void pindah(){
        Intent pindah =new Intent(this,MainActivity.class);
        startActivity(pindah);
    }
}
