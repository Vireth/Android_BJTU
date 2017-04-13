package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProximityActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(LightSensor != null){
            mySensorManager.registerListener(
                    LightSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }else{

        }
    }

    private final SensorEventListener LightSensorListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                if (event.values[0] >= 0 && event.values[0] <= 115) {
                    ConstraintLayout foodLabel = (ConstraintLayout) findViewById(R.id.background);
                    foodLabel.setBackgroundColor(Color.BLACK);

                    Button foodLabe1 = (Button) findViewById(R.id.button34);
                    TextView foodLabe2 = (TextView) findViewById(R.id.button33);

                    foodLabe1.setVisibility(View.INVISIBLE);
                    foodLabe2.setVisibility(View.INVISIBLE);
                }
                else {
                    ConstraintLayout foodLabel = (ConstraintLayout) findViewById(R.id.background);
                    foodLabel.setBackgroundColor(Color.WHITE);

                    Button foodLabe1 = (Button) findViewById(R.id.button34);
                    TextView foodLabe2 = (TextView) findViewById(R.id.button33);

                    foodLabe1.setVisibility(View.VISIBLE);
                    foodLabe2.setVisibility(View.VISIBLE);
                }
            }
        }

    };

    public void sendOK(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "SUCCESS");
        setResult(25, intent);
        finish();
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(25, intent);
        finish();
    }
}
