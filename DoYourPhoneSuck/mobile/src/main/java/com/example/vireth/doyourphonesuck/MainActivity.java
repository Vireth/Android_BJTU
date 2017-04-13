package com.example.vireth.doyourphonesuck;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.example.vireth.doyourphonesuck.R.id.listView;

public class MainActivity extends AppCompatActivity {
    String[] android = new String[]{
            "Information of Phone", "SDK", "Version", "Brand", "Manufacturer", "Model",
            "Information of Sims Card",
            "deviceId", "simSerialNumber", "networkCountryIso", "simCountryIso", "deviceSoftwareVersion", "voiceMailNumber", "simOperatorName"
    };

    String[] android_description = new String[]{
            "", String.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE,
            Build.BRAND, Build.MANUFACTURER, Build.MODEL,
            "", "", "", "", "", "", "", ""
    };

    String[] prenoms = new String[]{
            "Camera", "Camera", "Front Camera", "Flash", "Button camera",
            "Display", "Touch screen", "Display", "keyboard",
            "Son", "Speaker", "Listen", "Micro", "Vibration", "Increase volume", "Decrease volume",
            "Wireless", "WLAN", "Bluetooth", "GPS",
            "Connection", "Charging", "USB",
            "Sensor", "Light sensor", "Proximity of the ear","Accelerometer", "Gyroscope"
    };

    String[] validation = new String[]{
            "", "", "", "", "",
            "", "", "", "",
            "", "", "", "", "", "", "",
            "", "", "", "",
            "", "", "",
            "", "", "","", ""
    };

    int[] listviewImage = new int[]{
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_camera_alt_black_24dp,
            R.drawable.ic_camera_front_black_24dp,
            R.drawable.ic_flash_on_black_24dp,
            R.drawable.ic_label_black_24dp,
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_gesture_black_24dp,
            R.drawable.ic_stay_current_portrait_black_24dp,
            R.drawable.ic_keyboard_black_24dp,
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_volume_up_black_24dp,
            R.drawable.ic_hearing_black_24dp,
            R.drawable.ic_mic_black_24dp,
            R.drawable.ic_vibration_black_24dp,
            R.drawable.ic_arrow_drop_up_black_24dp,
            R.drawable.ic_arrow_drop_down_black_24dp,
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_wifi_black_24dp,
            R.drawable.ic_bluetooth_black_24dp,
            R.drawable.ic_map_black_24dp,
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_battery_charging_full_black_24dp,
            R.drawable.usb,
            R.drawable.ic_blanc_24dp,
            R.drawable.ic_brightness_medium_black_24dp,
            R.drawable.ic_hearing_black_24dp,
            R.drawable.ic_phonelink_ring_black_24dp,
            R.drawable.ic_screen_rotation_black_24dp,
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ListView androidListView = (ListView) findViewById(listView);
            List<HashMap<String, String>> aList2;

            TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

            String deviceId = tm.getDeviceId();
            String simSerialNumber = tm.getSimSerialNumber();
            String networkCountryIso = tm.getNetworkCountryIso();
            String simCountryIso = tm.getSimCountryIso();
            String deviceSoftwareVersion = tm.getDeviceSoftwareVersion();
            String voiceMailNumber = tm.getVoiceMailNumber();
            String simOperatorName = tm.getSimOperatorName();

            android_description[7] = deviceId;
            android_description[8] = simSerialNumber;
            android_description[9] = networkCountryIso;
            android_description[10] = simCountryIso;
            android_description[11] = deviceSoftwareVersion;
            android_description[12] = voiceMailNumber;
            android_description[13] = simOperatorName;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    aList2 = new ArrayList<HashMap<String, String>>();

                    for (int i = 0; i < android.length ; i++) {
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("listview_title", android[i]);
                        hm.put("listview_description", android_description[i]);
                        aList2.add(hm);
                    }

                    String[] from1 = {"listview_title", "listview_description"};
                    int[] to1 = {R.id.title, R.id.text};

                    SimpleAdapter simpleAdapter1 = new SimpleAdapter(getBaseContext(), aList2, R.layout.listview_version, from1, to1);
                    androidListView = (ListView) findViewById(listView);
                    androidListView.setAdapter(simpleAdapter1);
                    return true;
                case R.id.navigation_dashboard:
                    aList2 = new ArrayList<HashMap<String, String>>();

                    for (int i = 0; i < prenoms.length ; i++) {
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("listview_title", prenoms[i]);
                        hm.put("listview_image", Integer.toString(listviewImage[i]));
                        hm.put("listview_discription", validation[i]);
                        aList2.add(hm);
                    }

                    String[] from2 = {"listview_image", "listview_title", "listview_discription"};
                    int[] to2 = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

                    SimpleAdapter simpleAdapter2 = new SimpleAdapter(getBaseContext(), aList2, R.layout.listview_activity, from2, to2);
                    androidListView = (ListView) findViewById(listView);
                    androidListView.setAdapter(simpleAdapter2);

                    androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent newActivity = null;
                            switch( position )
                            {
                                case 0:  newActivity = null; // CAMERA
                                    break;
                                case 1:  newActivity = new Intent(getBaseContext(), activity_camera_back.class);
                                    break;
                                case 2:  newActivity = new Intent(getBaseContext(), CameraFront.class);
                                    break;
                                case 3:  newActivity = new Intent(getBaseContext(), FlashActivity.class);
                                    break;
                                case 4:  newActivity = new Intent(getBaseContext(), CameraDownActivity.class);
                                    break;
                                case 5:  newActivity = null; // DISPLAY
                                    break;
                                case 6:  newActivity = new Intent(getBaseContext(), TouchActivity.class);
                                    break;
                                case 7:  newActivity = new Intent(getBaseContext(), DisplayActivity.class);
                                    break;
                                case 8:  newActivity = new Intent(getBaseContext(), Keyboard.class);
                                    break;
                                case 9:  newActivity = null; // SON
                                    break;
                                case 10:  newActivity = new Intent(getBaseContext(), SoundActivity.class);
                                    break;
                                case 11:  newActivity = new Intent(getBaseContext(), ListenActivity.class);
                                    break;
                                case 12:  newActivity = new Intent(getBaseContext(), AudioActivity.class);
                                    break;
                                case 13:  newActivity = new Intent(getBaseContext(), Vibratore.class);
                                    break;
                                case 14:  newActivity = new Intent(getBaseContext(), VolumUpActivity.class);
                                    break;
                                case 15:  newActivity = new Intent(getBaseContext(), VolumDownActivity.class);
                                    break;
                                case 16:  newActivity = null; // WIRELESS
                                    break;
                                case 17:  newActivity = new Intent(getBaseContext(), WifiActivity.class);
                                    break;
                                case 18:  newActivity = new Intent(getBaseContext(), BluetoothActivity.class);
                                    break;
                                case 19:  newActivity = new Intent(getBaseContext(), FlashActivity.class);
                                    break;
                                case 20:  newActivity = null; // Connection
                                    break;
                                case 21:  newActivity = new Intent(getBaseContext(), Charging.class);
                                    break;
                                case 22:  newActivity = new Intent(getBaseContext(), UsbActivity.class);
                                    break;
                                case 23:  newActivity = null; // Sensor
                                    break;
                                case 24:  newActivity = new Intent(getBaseContext(), LightsensorActivity.class);
                                    break;
                                case 25:  newActivity = new Intent(getBaseContext(), ProximityActivity.class);
                                    break;
                                case 26:  newActivity = new Intent(getBaseContext(), AccelerometerActivity.class);
                                    break;
                                case 27:  newActivity = new Intent(getBaseContext(), GyroscopeActivity.class);
                                    break;
                            }
                            if (newActivity != null)
                                startActivityForResult(newActivity, 1);
                        }
                    });
                    return true;
                case R.id.navigation_notifications:
                    androidListView.setAdapter(null);
                    return true;
            }
            return false;
        }
    };

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode >= 0 && resultCode <= 27) {
                String newText = data.getStringExtra("editTextValue");
                validation[resultCode] = getDateTime() + " | " + newText;

                List<HashMap<String, String>> aList2 = new ArrayList<HashMap<String, String>>();

                for (int i = 0; i < prenoms.length ; i++) {
                    HashMap<String, String> hm = new HashMap<String, String>();
                    hm.put("listview_title", prenoms[i]);
                    hm.put("listview_image", Integer.toString(listviewImage[i]));
                    hm.put("listview_discription", validation[i]);
                    aList2.add(hm);
                }

                String[] from2 = {"listview_image", "listview_title", "listview_discription"};
                int[] to2 = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

                String test = "";
                for (int i = 0; i < validation.length ; i++) {
                    test = test + validation[i] + ";";
                }
                SharedPreferences save = getSharedPreferences("info", MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putString("key5", test);
                editor.commit();

                SimpleAdapter simpleAdapter2 = new SimpleAdapter(getBaseContext(), aList2, R.layout.listview_activity, from2, to2);
                ListView androidListView = (ListView) findViewById(listView);
                androidListView.setAdapter(simpleAdapter2);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{PackageManager.FEATURE_CAMERA_FLASH}, 1);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        List<HashMap<String, String>> aList2 = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < android.length ; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", android[i]);
            hm.put("listview_description", android_description[i]);
            aList2.add(hm);
        }

        String[] from1 = {"listview_title", "listview_description"};
        int[] to1 = {R.id.title, R.id.text};

        SimpleAdapter simpleAdapter1 = new SimpleAdapter(getBaseContext(), aList2, R.layout.listview_version, from1, to1);
        ListView androidListView = (ListView) findViewById(listView);
        androidListView.setAdapter(simpleAdapter1);

        SharedPreferences shared = getSharedPreferences("info", MODE_PRIVATE);
        String string_temp = shared.getString("key5", "0");

        int t = 0;
        int i = 0;
        String test2 = "";

        while (t != string_temp.length()) {
            if (string_temp.charAt(t) == ';')
            {
                if (test2.length() < 2)
                    validation[i] = "";
                else
                    validation[i] = test2;
                test2 = "";
                i++;
            }
            else {
                test2 = test2 + string_temp.charAt(t);
            }
            t++;
        }

//        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage(String.valueOf(i));
//        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        alertDialog.show();
    }
}
