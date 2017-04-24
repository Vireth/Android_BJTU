package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Charging extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);
    }

    public void sendOK(View view) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, filter);

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        if (isCharging) {
            Intent intent = new Intent();
            intent.putExtra("editTextValue", "SUCCESS");
            setResult(21, intent);
            finish();
        }
        else {
            sendNo(view);
        }
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(21, intent);
        finish();
    }
}
