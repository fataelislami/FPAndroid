package com.example.fataelislami.sensorkomurindo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.fataelislami.sensorkomurindo.View.Acelerometer;
import com.example.fataelislami.sensorkomurindo.View.GPS;
import com.example.fataelislami.sensorkomurindo.View.Gyroscope;
import com.example.fataelislami.sensorkomurindo.View.KOMPAS;
import com.example.fataelislami.sensorkomurindo.View.Orientasi;
import com.example.fataelislami.sensorkomurindo.View.SemuaSensor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.GyroButton)
    Button gyro;
    @BindView(R.id.AcelButton)
    Button acel;
    @BindView(R.id.SS)
    Button SS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.AcelButton)
    public void pindahAcel(){
        Intent i = new Intent(this, Acelerometer.class);
        startActivity(i);
    }
    @OnClick(R.id.GyroButton)
    public void pindahGyro(){
        Intent Gyro=new Intent(this,Gyroscope.class);
        startActivity(Gyro);
    }
    @OnClick(R.id.MagnetButton)
    public void pindahMagnet(){
        Intent Kompas=new Intent(this,KOMPAS.class);
        startActivity(Kompas);
    }
    @OnClick(R.id.TombolGPS)
    public void pindahGPS(){
        Intent GPS=new Intent(this,GPS.class);
        startActivity(GPS);
    }
    @OnClick(R.id.ButtonOrientasi)
    public void pindahOrientasi(){
        Intent Orientasi=new Intent(this,Orientasi.class);
        startActivity(Orientasi);
    }
    @OnClick(R.id.SS)
    public void semuasensor(){
        Intent SS = new Intent(this, SemuaSensor.class);
        startActivity(SS);
    }

}
