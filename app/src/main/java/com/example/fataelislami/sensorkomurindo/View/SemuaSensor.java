package com.example.fataelislami.sensorkomurindo.View;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fataelislami.sensorkomurindo.GpsService;
import com.example.fataelislami.sensorkomurindo.R;
import com.example.fataelislami.sensorkomurindo.SensorHelper;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SemuaSensor extends AppCompatActivity implements SensorEventListener{
    @BindView(R.id.TAcelX)
    TextView TAcelX;
    @BindView(R.id.TAcelY)
    TextView TAcelY;
    @BindView(R.id.TAcelZ)
    TextView TAcelZ;
    @BindView(R.id.xOrientasi) TextView xOrientasi;
    @BindView(R.id.yOrientasi) TextView yOrientasi;
    @BindView(R.id.zOrientasi) TextView zOrientasi;
    @BindView(R.id.xGyros) TextView xGyros;
    @BindView(R.id.yGyros) TextView yGyros;
    @BindView(R.id.zGyros) TextView zGyros;
    @BindView(R.id.xKompasensor) TextView xKompas;
    @BindView(R.id.Lattitude) TextView Lattitude;
    @BindView(R.id.Longitude) TextView Longitude;
    @BindView(R.id.Altitude)  TextView Altitude;
    @BindView(R.id.RefreshGPS)
    Button RefreshGPS;
    protected LocationManager locationManager;
    Location location;
    SensorHelper sh;
    private boolean mInitialized;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semua_sensor);
        ButterKnife.bind(this);


        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sh = new SensorHelper();
        sh.initSensorGyro(this, mSensorManager);
        sh.initSensorAccelerometer(this, mSensorManager);
        sh.initSensorOrientasi(this, mSensorManager);
        sh.initSensorKompas(this,mSensorManager);
        boolean mInitialized = false;

        GpsService gps = new GpsService(SemuaSensor.this);
        // dicek dulu apakah GPSnya idup
        if (gps.canGetLocation())
        {
            // ambil latitude dan longitude
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            double altitude = gps.getAltitude();

            // tampilkan make Toast
            Lattitude.setText("Lattitude : "+gps.getLatitude());
            Longitude.setText("Longitude : "+gps.getLongitude());
            Altitude.setText("Altitude :"+gps.getAltitude());
        } else
        {
            // jika GPS tidak aktif
            gps.showSettingAlert();
        }



    }
    @OnClick(R.id.RefreshGPS)
    public void klik(){
        GpsService gps =new GpsService(SemuaSensor.this);
        Lattitude.setText("Lattitude : "+gps.getLatitude());
        Longitude.setText("Longitude : "+gps.getLongitude());
        Altitude.setText("Altitude :"+gps.getAltitude());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER: {
                final float NOISE = (float) 2.0;

                float posisiX = 0,posisiY = 0,posisiZ = 0;
                float deltaX,deltaY,deltaZ;
                sh.xAccel = sensorEvent.values[0];
                sh.yAccel = sensorEvent.values[1];
                sh.zAccel = sensorEvent.values[2];
                if (!mInitialized) {
                    posisiX = sh.xAccel;
                    posisiY = sh.yAccel;
                    posisiZ = sh.zAccel;
                    TAcelX.setText("0.0");
                    TAcelY.setText("0.0");
                    TAcelZ.setText("0.0");
                    mInitialized = true;
                    System.out.println("ACCEL" + sh.xAccel);
                }
                else {
                    deltaX = Math.abs(posisiX - sh.xAccel);
                    deltaY = Math.abs(posisiY - sh.yAccel);
                    deltaZ = Math.abs(posisiZ - sh.zAccel);
                    if (deltaX < NOISE) deltaX = (float)0.0;
                    if (deltaY < NOISE) deltaY = (float)0.0;
                    if (deltaZ < NOISE) deltaZ = (float)0.0;
                    posisiX = sh.xAccel;
                    posisiY = sh.yAccel;
                    posisiZ = sh.zAccel;
                   TAcelX.setText(Float.toString(deltaX));
                   TAcelY.setText(Float.toString(deltaY));
                   TAcelZ.setText(Float.toString(deltaZ));
                    System.out.println("ACCEL X " + sh.xAccel);
                    System.out.println("ACCEL Y "+ sh.yAccel);
                }
            }
            break;
            case Sensor.TYPE_GYROSCOPE: {
                sh.xGyro = sensorEvent.values[0];
                sh.yGyro = sensorEvent.values[1];
                sh.zGyro = sensorEvent.values[2];
                if(sensorEvent.accuracy==SensorManager.SENSOR_STATUS_UNRELIABLE){
                    return;
                }
                xGyros.setText(""+sh.xGyro);
                yGyros.setText(""+sh.yGyro);
                zGyros.setText(""+sh.zGyro);

            }
            break;
            case Sensor.TYPE_ORIENTATION:{
                sh.xKompas=Math.round(sensorEvent.values[0]);
                sh.xOrientasi= sensorEvent.values[0];
                sh.yOrientasi= sensorEvent.values[1];
                sh.zOrientasi= sensorEvent.values[2];

                xOrientasi.setText(""+sh.xOrientasi);
                yOrientasi.setText(""+sh.yOrientasi);
                zOrientasi.setText(""+sh.zOrientasi);

                System.out.println("ORIENTASI"+sh.xOrientasi);
                xKompas.setText(""+sh.xKompas);

            }
            break;

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
