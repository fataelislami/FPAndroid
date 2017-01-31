package com.example.fataelislami.sensorkomurindo.View;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fataelislami.sensorkomurindo.Presenter.AkseleroClass;
import com.example.fataelislami.sensorkomurindo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.Toast.LENGTH_LONG;

public class Aksel extends AppCompatActivity {
    AkseleroClass sensor;
    @BindView(R.id.AkselX)
    TextView TextAkselX;


    float x,y,z;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksel);
        ButterKnife.bind(this);

        AkseleroClass aksel = new AkseleroClass(getApplicationContext());
        aksel.onSensorChanged();
    }
}
