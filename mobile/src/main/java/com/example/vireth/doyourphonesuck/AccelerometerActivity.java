package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    double ax,ay,az;
    TextView textView19, textView20, textView21;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ax = event.values[0];
            ay = event.values[1];
            az = event.values[2];

            textView19 = (TextView)findViewById(R.id.textView19);
            textView20 = (TextView)findViewById(R.id.textView20);
            textView21 = (TextView)findViewById(R.id.textView21);

            textView19.setText("AX: " + Double.toString(ax));
            textView20.setText("AY: " + Double.toString(ay));
            textView21.setText("AZ: " + Double.toString(az));
        }
    }

    public void sendOK(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "SUCCESS");
        setResult(26, intent);
        finish();
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(26, intent);
        finish();
    }
}
