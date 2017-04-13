package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LightsensorActivity extends AppCompatActivity {

    TextView textLIGHT_available, textLIGHT_reading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightsensor);

        textLIGHT_available = (TextView)findViewById(R.id.LIGHT_available);
        textLIGHT_reading = (TextView)findViewById(R.id.LIGHT_reading);

        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(LightSensor != null){
            textLIGHT_available.setText("Sensor.TYPE_LIGHT Available");
            mySensorManager.registerListener(
                    LightSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            textLIGHT_available.setText("Sensor.TYPE_LIGHT NOT Available");
        }
    }

    private final SensorEventListener LightSensorListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                textLIGHT_reading.setText("LIGHT: " + event.values[0]);
                if (event.values[0] >= 0 && event.values[0] <= 10) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(0);
                }
                else if (event.values[0] >= 10 && event.values[0] <= 25) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(28);
                }
                else if (event.values[0] >= 25 && event.values[0] <= 50) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(56);
                }
                else if (event.values[0] >= 50 && event.values[0] <= 100) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(84);
                }
                else if (event.values[0] >= 100 && event.values[0] <= 150) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(112);
                }
                else if (event.values[0] >= 150 && event.values[0] <= 250) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(140);
                }
                else if (event.values[0] >= 250 && event.values[0] <= 400) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(168);
                }
                else if (event.values[0] >= 400 && event.values[0] <= 800) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(196);
                }
                else if (event.values[0] >= 800 && event.values[0] <= 1500) {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(224);
                }
                else {
                    ImageView myImage = (ImageView) findViewById(R.id.imageView12);
                    myImage.setAlpha(255);
                }
            }
        }

    };

    public void sendOK(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "SUCCESS");
        setResult(24, intent);
        finish();
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(24, intent);
        finish();
    }
}
