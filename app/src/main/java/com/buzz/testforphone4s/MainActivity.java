package com.buzz.testforphone4s;


import android.app.Activity;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    TextView ambient_temp;
    String hello = "hello";
    String hello2 = "world";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ambient_temp = (TextView) findViewById(R.id.temp);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float ambient_temperature = event.values[0];
        System.out.println("TEMP IS thisKENG " + ambient_temperature);
        ambient_temp.setText(Float.toString(ambient_temperature));

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
