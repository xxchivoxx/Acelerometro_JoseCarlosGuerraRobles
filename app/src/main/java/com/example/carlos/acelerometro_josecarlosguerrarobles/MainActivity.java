package com.example.carlos.acelerometro_josecarlosguerrarobles;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView txtEjeX, txtEjeY, txtEjeZ;
    private Sensor mysensor;
    private SensorManager sensorManager;

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        txtEjeX = findViewById(R.id.txtEjeX);
        txtEjeY = findViewById(R.id.txtEjeY);
        txtEjeZ = findViewById(R.id.txtEjeZ);


    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        txtEjeX.setText("Eje X: "+ event.values[0]);
        txtEjeY.setText("Eje Y: "+ event.values[1]);
        txtEjeZ.setText("Eje Z: "+ event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume (){
        super.onResume();
        sensorManager.registerListener(this,mysensor, SensorManager.SENSOR_DELAY_NORMAL );
    }

    @Override
    protected void onPause (){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
