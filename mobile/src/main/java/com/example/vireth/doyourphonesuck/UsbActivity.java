package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UsbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usb);

//        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
//        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
//        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC; // USB - PLUG
    }

    public void sendOK(View view) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, filter);

        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;

        if (usbCharge) {
            Intent intent = new Intent();
            intent.putExtra("editTextValue", "SUCCESS");
            setResult(22, intent);
            finish();
        }
        else {
            sendNo(view);
        }
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(22, intent);
        finish();
    }
}
