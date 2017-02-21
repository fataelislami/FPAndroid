package com.example.fataelislami.sensorkomurindo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.fataelislami.sensorkomurindo.GpsService;
import com.example.fataelislami.sensorkomurindo.MainActivity;
import com.example.fataelislami.sensorkomurindo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GPSAct extends AppCompatActivity {
    @BindView(R.id.GPSTombol)
    Button GPSTombol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps2);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.GPSTombol)
    public void Klik(){
        GpsService gps = new GpsService(GPSAct.this);
        // dicek dulu apakah GPSnya idup
        if (gps.canGetLocation())
        {
            // ambil latitude dan longitude
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // tampilkan make Toast
            Toast.makeText(getApplicationContext(),
                    "Lokasi mu latitude: " + latitude + " Longitude : " + longitude, Toast.LENGTH_LONG).show();
        } else
        {
            // jika GPS tidak aktif
            gps.showSettingAlert();
        }
    }
}
