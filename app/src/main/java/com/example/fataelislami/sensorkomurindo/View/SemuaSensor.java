package com.example.fataelislami.sensorkomurindo.View;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fataelislami.sensorkomurindo.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SemuaSensor extends AppCompatActivity {
    @BindView(R.id.TAcelX)
    TextView TAcelX;
    @BindView(R.id.TAcelY)
    TextView TAcelY;
    @BindView(R.id.TAcelZ)
    TextView TAcelZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semua_sensor);
        ButterKnife.bind(this);

        Acelerometer Acel = new Acelerometer();
        TAcelX.setText(""+Acel.AcelX);
        TAcelY.setText(""+Acel.AcelY);
        TAcelZ.setText(""+Acel.AcelZ);
    }
}
