package com.example.vireth.doyourphonesuck;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    int nb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        Button foodLabe2 = (Button) findViewById(R.id.button12);
        Button foodLabe3 = (Button) findViewById(R.id.button13);
        TextView foodLabe4 = (TextView) findViewById(R.id.textView7);
        ImageView foodLabe5 = (ImageView) findViewById(R.id.imageView6);

        foodLabe2.setVisibility(View.INVISIBLE);
        foodLabe3.setVisibility(View.INVISIBLE);
        foodLabe4.setVisibility(View.INVISIBLE);
        foodLabe5.setVisibility(View.INVISIBLE);
    }

    public void next(View view) {
        ConstraintLayout foodLabel = (ConstraintLayout) findViewById(R.id.background);
        foodLabel.setBackgroundColor(Color.BLACK);

        Button foodLabe1 = (Button) findViewById(R.id.button14);
        TextView foodLabe2 = (TextView) findViewById(R.id.textView8);

        foodLabe1.setVisibility(View.INVISIBLE);
        foodLabe2.setVisibility(View.INVISIBLE);

        this.nb++;
    }

    public void changeColor(View view) {
        ConstraintLayout foodLabel = (ConstraintLayout) findViewById(R.id.background);
        foodLabel.setBackgroundColor(Color.WHITE);

        // Drawable color = foodLabel.getBackground();
        if (this.nb >= 2) {
            Button foodLabe2 = (Button) findViewById(R.id.button12);
            Button foodLabe3 = (Button) findViewById(R.id.button13);
            TextView foodLabe4 = (TextView) findViewById(R.id.textView7);
            ImageView foodLabe5 = (ImageView) findViewById(R.id.imageView6);

            foodLabe2.setVisibility(View.VISIBLE);
            foodLabe3.setVisibility(View.VISIBLE);
            foodLabe4.setVisibility(View.VISIBLE);
            foodLabe5.setVisibility(View.VISIBLE);
        }
        this.nb++;
    }

    public void sendOK(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "SUCCESS");
        setResult(7, intent);
        finish();
    }

    public void sendNo(View view) {
        Intent intent = new Intent();
        intent.putExtra("editTextValue", "FAIL");
        setResult(7, intent);
        finish();
    }
}
