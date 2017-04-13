package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Keyboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
    }

    public void sendOK(View view) {
        EditText text = (EditText)findViewById(R.id.editText);
        String value = text.getText().toString();

        if (value.equals("Sun Wukong")) {
            Intent intent = new Intent();
            intent.putExtra("editTextValue", "SUCCESS");
            setResult(8, intent);
            finish();
        }
        else {
            sendNo(view);
        }
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(8, intent);
        finish();
    }
}
