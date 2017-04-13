package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListenActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);

        mediaPlayer = MediaPlayer.create(this, R.raw.stefano);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.start();
    }

    public void sendOK(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "SUCCESS");
        mediaPlayer.stop();
        setResult(11, intent);
        finish();
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        mediaPlayer.stop();
        setResult(11, intent);
        finish();
    }
}
